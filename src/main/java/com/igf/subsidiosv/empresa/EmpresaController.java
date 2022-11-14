package com.igf.subsidiosv.empresa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpresaController {
    
    @GetMapping("/empresa")
    public String empresa(){

        return "empresa/empresa";

    }

}
