package com.igf.subsidiosv.consumo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.igf.subsidiosv.empresa.Empresa;
import com.igf.subsidiosv.empresa.EmpresaRepository;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import org.springframework.ui.Model;

@Controller
public class ConsumoController {
    @Autowired 
    private ConsumoRepository consumoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping("/consumo")
    public String listarConsumo(Model model) {
        List<Consumo> listaConsumos = consumoRepository.findAll();
        model.addAttribute("listaConsumos", listaConsumos);

        return "consumo/consumo";
    }

    @GetMapping("/consumonuevo")
    public String mostrarFormularioDeNuevoConsumo(Model model){
        List<Empresa> listaEmpresas = empresaRepository.findAll(); 
        model.addAttribute("consumo", new Consumo());
        model.addAttribute("listaEmpresas", listaEmpresas);

        return "consumo/consumo_form";

    }

    @PostMapping("/consumo/guardar")
    public String guadarConsumo(Consumo consumo){
        consumoRepository.save(consumo);
        return "redirect:/consumo";

    }
    @GetMapping("/consumoeditar/{id}")
    public String mostrarFormularioDeEditarConsumoString(Model model, @PathVariable Integer id) {
        List<Empresa> listaEmpresas= empresaRepository.findAll();

        Optional<Consumo> consumo = consumoRepository.findById(id);
        model.addAttribute("consumo", consumo);
        model.addAttribute("listaEmpresas", listaEmpresas);
        return "consumo/consumo_form";
    }

    @GetMapping("/consumoeliminar/{id}")
    public String eliminarConsumo(Model model, @PathVariable Integer id) {
        consumoRepository.deleteById(id);
        return "redirect:/consumo";
    }

}
