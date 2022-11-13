package com.igf.subsidiosv.solicitud;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.igf.subsidiosv.producto.Producto;
import com.igf.subsidiosv.producto.ProductoRepository;

@Controller
public class SolicitudController {

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Autowired
    private ProductoRepository productoRepository;
    
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

}
