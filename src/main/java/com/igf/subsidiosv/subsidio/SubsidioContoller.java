package com.igf.subsidiosv.subsidio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.igf.subsidiosv.beneficio.Beneficio;
import com.igf.subsidiosv.producto.Producto;
import com.igf.subsidiosv.producto.ProductoRepository;
import com.igf.subsidiosv.rol.Rol;
import com.igf.subsidiosv.rol.RolRepository;


@Controller
public class SubsidioContoller {
   
    @Autowired
    private SubsidioRepository subsidioRepository;


    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private RolRepository rolRepository;
   
    @GetMapping("/subsidios")
    public String listarsubsidio(Model model) {
        List<Subsidio> listaSubsidio = subsidioRepository.findAll();
        model.addAttribute("listaSubsidio", listaSubsidio);

        return "subsidios/subsidios";
    }

    @GetMapping("/beneficionuevo")
    public String mostrarFormularioDeNuevoBeneficio(Model model) {
        List<Rol> listaRoles = rolRepository.findAll();

        model.addAttribute("beneficio", new Beneficio());
        model.addAttribute("listaRoles", listaRoles);

        return "subsidios/subsidios_form";
    }

    @GetMapping("/productonuevo")
    public String mostrarFormularioDeNuevoProducto(Model model) {
        List<Producto> listaProducto = productoRepository.findAll();

        model.addAttribute("producto", new Producto());
        model.addAttribute("listaProducto", listaProducto);

        return "subsidios/subsidios_form";
    }


    @PostMapping("/subsidios/guardar")
    public String guardarSubsidio(Subsidio subsidio) {
        subsidioRepository.save(subsidio);
        return "redirect:/subsidios";
    }

    @GetMapping("/subsidioeditar/{id}")
    public String mostrarFormularioDeEditarSubsidio(Model model, @PathVariable Integer id) {
        List<Rol> listaRoles = rolRepository.findAll();
        List<Producto> listaProducto = productoRepository.findAll();

        Optional<Subsidio> subsidio = subsidioRepository.findById(id);
        model.addAttribute("beneficio", subsidio);
        model.addAttribute("listaRoles", listaRoles);
        model.addAttribute("producto", subsidio);
        model.addAttribute("listaProducto", listaProducto);
        return "subsidios/subsidios_form";
    }

    @GetMapping("/subsidioeliminar/{id}")
    public String eliminarSubsidio(Model model, @PathVariable Integer id) {
        subsidioRepository.deleteById(id);
        return "redirect:/subsidios";
    }
    
}

