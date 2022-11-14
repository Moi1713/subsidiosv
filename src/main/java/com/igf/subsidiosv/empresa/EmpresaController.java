package com.igf.subsidiosv.empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpresaController {
    
    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping("/empresa")
    public String nuevaEmpresa(Model model){

        model.addAttribute("empresa", new Empresa());

        return "empresa/empresa";

    }

    @PostMapping("/empresa/guardar")
    public String guadarEmpresa(Empresa empresa){

        empresaRepository.save(empresa);

        return "redirect:/empresa";
    }

}
