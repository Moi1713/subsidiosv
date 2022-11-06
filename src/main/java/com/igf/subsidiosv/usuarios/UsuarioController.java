package com.igf.subsidiosv.usuarios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.igf.subsidiosv.rol.Rol;
import com.igf.subsidiosv.rol.RolRepository;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;
    
    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        model.addAttribute("listaUsuarios", listaUsuarios);

        return "usuarios/usuarios";
    }

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
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarioeditar/{id}")
    public String mostrarFormularioDeEditarUsuario(Model model, @PathVariable Integer id) {
        List<Rol> listaRoles = rolRepository.findAll();

        Optional<Usuario> usuario = usuarioRepository.findById(id);
        model.addAttribute("usuario", usuario);
        model.addAttribute("listaRoles", listaRoles);
        return "usuarios/usuario_form";
    }

    @GetMapping("/usuarioeliminar/{id}")
    public String eliminarUsuario(Model model, @PathVariable Integer id) {
        usuarioRepository.deleteById(id);
        return "redirect:/usuarios";
    }

}
