package com.igf.subsidiosv.empresa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpresaController {
    
    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping("/empresanuevo")
    public String nuevaEmpresa(Model model){
        model.addAttribute("empresa", new Empresa());
        return "empresa/empresa_form";
    }

    @GetMapping("/empresa")
    public String listarEmpresas(Model model) {
        List<Empresa> listaEmpresas = empresaRepository.findAll();
        model.addAttribute("listaEmpresas", listaEmpresas);
        return "empresa/empresa";
    }

    @PostMapping("/empresa/guardar")
    public String guadarEmpresa(Empresa empresa){

        empresaRepository.save(empresa);

        return "redirect:/empresa";
    }

    @GetMapping("/empresaeditar/{id}")
    public String mostrarFormularioDeEditarEmpresa(Model model, @PathVariable Integer id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        model.addAttribute("empresa", empresa);
        return "empresa/empresa_form";
    }
    @GetMapping("/empresaeliminar/{id}")
    public String eliminarEmpresa(Model model, @PathVariable Integer id) {
        empresaRepository.deleteById(id);
        return "redirect:/empresa";
    }

}
