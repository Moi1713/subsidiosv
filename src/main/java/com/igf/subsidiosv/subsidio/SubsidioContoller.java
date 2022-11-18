package com.igf.subsidiosv.subsidio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import java.util.Optional;

import com.igf.subsidiosv.beneficio.Beneficio;
import com.igf.subsidiosv.producto.Producto;
import com.igf.subsidiosv.producto.ProductoRepository;
import com.igf.subsidiosv.beneficio.BeneficioRepository;


@Controller
public class SubsidioContoller {
    @Autowired
    private SubsidioRepository subsidioRepository;

    @Autowired
    private ProductoRepository productoRepository;
    
    @Autowired
    private BeneficioRepository beneficioRepository;

    @GetMapping("/subsidios")
    public String listarSubsidio(Model model) {
        List<Subsidio> listaSubsidio = subsidioRepository.findAll();
        model.addAttribute("listaSubsidio", listaSubsidio);

        return "subsidios/subsidios";
    }

    @GetMapping("/subsidionuevo")
    public String mostrarFormularioDeNuevoSubsidio(Model model) {
        List<Beneficio> listaBeneficio = beneficioRepository.findAll();
        model.addAttribute("subsidio", new Subsidio());
        model.addAttribute("listaBeneficio", listaBeneficio);

        List<Producto> listaProductos = productoRepository.findAll();
        model.addAttribute("subsidio", new Subsidio());
        model.addAttribute("listaProductos", listaProductos);

        return "subsidios/subsidios_form";
    }

    @PostMapping("/subsidios/guardar")
    public String guardarSubsidio(Subsidio subsidio) {
        subsidioRepository.save(subsidio);
        return "redirect:/subsidios";
    }

    @GetMapping("/subsidioeditar/{id}")
    public String mostrarFormularioDeEditarSubsidio(Model model, @PathVariable Integer id) {
        List<Beneficio> listaBeneficio = beneficioRepository.findAll();
        List<Producto> listaProductos = productoRepository.findAll();

        Optional<Subsidio> subsidio = subsidioRepository.findById(id);
        model.addAttribute("subsidio", new Subsidio());
        model.addAttribute("listaBeneficio", listaBeneficio);
        model.addAttribute("listaProductos", listaProductos);
        model.addAttribute("subsidio", subsidio);
        return "subsidios/subsidios_form";
    }

    @GetMapping("/subsidioeliminar/{id}")
    public String eliminarSubsidio(Model model, @PathVariable Integer id) {
        subsidioRepository.deleteById(id);
        return "redirect:/subsidios";
    }
    
}

