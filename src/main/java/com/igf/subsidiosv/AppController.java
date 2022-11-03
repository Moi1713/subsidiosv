package com.igf.subsidiosv;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping({"/", "/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/muestra")
    public String muestra(){
        return "muestra";
    }

    @GetMapping("/_layout")
    public String layout(){
        return "_layout";
    }

    @GetMapping("/usuarios")
    public String usuarios(){
        return "usuarios/usuarios";
    }

    @GetMapping("/usuarioslistar")
    public String usuarioslistar(){
        return "usuarios/usuarioslistar";
    }

}
