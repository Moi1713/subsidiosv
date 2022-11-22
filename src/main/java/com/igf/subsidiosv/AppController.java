package com.igf.subsidiosv;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @GetMapping({"", "/", "/index"})
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String loginPage() { return "login"; }

    @RequestMapping("/logout")
    public String logoutPage() { return "login"; }

    @GetMapping("/_layout")
    public String layout(){
        return "_layout";
    }

    @GetMapping("/muestra")
    public String muestra(){
        return "muestra";
    }

    @GetMapping("/usuarioslistar")
    public String usuarioslistar(){
        return "usuarioslistar";
    }

    @GetMapping("/usuariosmuestra")
    public String usuariosmuestra(){
        return "usuariosmuestra";
    }

  
}
