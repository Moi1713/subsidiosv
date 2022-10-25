package com.igf.subsidiosv;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/_layout")
    public String layout(){
        return "_layout";
    }

    @GetMapping("/usuarios")
    public String usuarios(){
        return "usuarios/usuarios";
    }

}
