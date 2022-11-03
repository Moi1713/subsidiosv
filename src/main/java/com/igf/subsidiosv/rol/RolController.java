package com.igf.subsidiosv.rol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RolController {

    @Autowired
    private RolRepository rolRepository;

    @GetMapping("/roles")
    public String listarRoles(Model model) {
        List<Rol> listaRoles = rolRepository.findAll();
        model.addAttribute("listaRoles", listaRoles);
        return "roles/roles";
    }

    @GetMapping("/roles/nuevo")
    public String nuevoRol(Model model) {
        model.addAttribute("rol", new Rol());
        return "rol_form";
    }
}
