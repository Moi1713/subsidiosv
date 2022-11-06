package com.igf.subsidiosv.rol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/rolnuevo")
    public String mostrarFormularioDeNuevoRol(Model model) {
        model.addAttribute("rol", new Rol());
        return "roles/rol_form";
    }

    @PostMapping("/roles/guardar")
    public String guardarRol(Rol rol) {
        rolRepository.save(rol);
        return "redirect:/roles";
    }

    @GetMapping("/roleliminar/{id}")
    public String eliminarRol(Model model, @PathVariable Integer id) {
        rolRepository.deleteById(id);
        return "redirect:/roles";
    }

}
