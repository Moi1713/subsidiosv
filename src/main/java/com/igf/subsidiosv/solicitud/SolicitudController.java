package com.igf.subsidiosv.solicitud;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.igf.subsidiosv.beneficiario.Beneficiario;
import com.igf.subsidiosv.beneficiario.BeneficiarioRepository;
import com.igf.subsidiosv.beneficio.Beneficio;
import com.igf.subsidiosv.beneficio.BeneficioRepository;
import com.igf.subsidiosv.consumo.Consumo;
import com.igf.subsidiosv.consumo.ConsumoRepository;
import com.igf.subsidiosv.subsidio.Subsidio;
import com.igf.subsidiosv.subsidio.SubsidioRepository;
import com.igf.subsidiosv.subsidioaplicado.SubsidioAplicado;
import com.igf.subsidiosv.subsidioaplicado.SubsidioAplicadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.igf.subsidiosv.producto.Producto;
import com.igf.subsidiosv.producto.ProductoRepository;

@Controller
public class SolicitudController {

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private BeneficiarioRepository beficiarioRepository;

    @Autowired
    private ConsumoRepository consumoRepository;

    @Autowired
    private BeneficioRepository beneficioRepository;

    @Autowired
    private SubsidioRepository subsidioRepository;

    @Autowired
    private SubsidioAplicadoRepository subsidioAplicadoRepository;



    @GetMapping("/solicitudes")
    public String listarSolicitudes(Model model) {
        List<Solicitud> listaSolicitudes = solicitudRepository.findAll();
        model.addAttribute("listaSolicitudes", listaSolicitudes);

        return "solicitudes/solicitudes";
    }

    @GetMapping("/solicitudnuevo")
    public String mostrarFormularioDeNuevaSolicitud(Model model) {
        List<Producto> listaProductos = productoRepository.findAll();
        model.addAttribute("solicitud", new Solicitud());
        model.addAttribute("listaProductos", listaProductos);

        return "solicitudes/solicitud_form";
    }

    @PostMapping("/solicitudes/guardar")
    public String guardarSolicitud(Solicitud solicitud) {
        solicitud.setEstado("Ingresado");
        solicitudRepository.save(solicitud);
        return "redirect:/solicitudes";
    }

    @GetMapping("/solicitudeditar/{id}")
    public String mostrarFormularioDeEditarSolicitud(Model model, @PathVariable Integer id) {
        List<Producto> listaProductos = productoRepository.findAll();

        Optional<Solicitud> solicitud = solicitudRepository.findById(id);
        model.addAttribute("solicitud", solicitud);
        model.addAttribute("listaProductos", listaProductos);
        return "solicitudes/solicitud_form";
    }

    @GetMapping("/solicitudeliminar/{id}")
    public String eliminarSolicitud(Model model, @PathVariable Integer id) {
        solicitudRepository.deleteById(id);
        return "redirect:/solicitudes";
    }

    @PostMapping("/validarSolicitudes/{id}")
    public @ResponseBody
    Map<String, Object> validarSolicitudes(Model model, @PathVariable Integer id) {
        SubsidioAplicado subsidioAplicado = new SubsidioAplicado();
        Beneficiario beneficiarioOne = new Beneficiario();
        Producto productoOne = new Producto();
        Beneficio beneficioOne = new Beneficio();
        Solicitud   solicitudOne = new Solicitud();

        Subsidio subsidioOne = new Subsidio ();
        Map<String, Object> result = new HashMap<>();
        Double total;



        Beneficiario beneficiario= solicitudRepository.findSolicitudBeneficiario(id);
        if (beneficiario!=null) {

            Integer consumo = consumoRepository.findConsumo(beneficiario.getDui());
            if (consumo == null){
                consumo = 0;
            }
            Solicitud solicitud = solicitudRepository.findSolicitud(id);
            Double precio =solicitud.getProducto().getPrecio();
            Integer idProducto =solicitud.getProducto().getId();
            Integer idBeneficio=beneficiario.getBeneficio().getId();
            Subsidio sudsidio=subsidioRepository.findSubsidio(idProducto,idBeneficio);

            Date date = new Date();

            if (consumo <= 99) {
                total = precio - sudsidio.getMonto();
                //Colocar parametros para subsidio aplicado
                beneficiarioOne.setId(beneficiario.getId());
                subsidioAplicado.setBeneficiario(beneficiarioOne);
                solicitudOne.setId(solicitud.getId());
                subsidioAplicado.setSolicitud(solicitudOne);
                productoOne.setId(idProducto);
                subsidioAplicado.setProducto(productoOne);
                beneficioOne.setId(idBeneficio);
                subsidioAplicado.setBeneficio(beneficioOne);
                subsidioOne.setId(sudsidio.getId());
                subsidioAplicado.setSubsidio(subsidioOne);
                subsidioAplicado.setTotal(total);
                subsidioAplicado.setFecha_registro(date);
                subsidioAplicadoRepository.save(subsidioAplicado);
                result.put("code", 0);
                result.put("msj", "Su registro se Actualizo exitosamente.");
                solicitud.setEstado("Aprobado");
                solicitudRepository.save(solicitud);


            } else {

                result.put("code", 1);
                result.put("msj", "El consumo de energía sobrepasa la cantidad máxima.");
                solicitud.setEstado("Rechazado");
                solicitudRepository.save(solicitud);

            }
        }else{
            result.put("code", 1);
            result.put("msj", "El DUI ingresado no se encuentra en la Base de Datos.");
        }

        return result;
    }

}
