package com.igf.subsidiosv.usuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.igf.subsidiosv.rol.Rol;
import com.igf.subsidiosv.rol.RolRepository;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;
    
    @GetMapping("/usuarionuevo")
    public String mostrarFormularioDeNuevoUsuario(Model model) {
        List<Rol> listaRoles = rolRepository.findAll();

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("listaRoles", listaRoles);

        return "usuarios/usuario_form";
    }

    @PostMapping("/usuarios/guardar")
    public String guardarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
        return "redirect:/";
    }

}
