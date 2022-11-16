package com.igf.subsidiosv.categoria;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/categorías")
    public String listaCategorias(Model model) {
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        model.addAttribute("listaCategorias", listaCategorias);
        return "categorias/categorias";
    }

    @GetMapping("/categorías/nuevo")
    public String mostrarFormularioDeNuevaCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias/categoria_form";
    }

    @PostMapping("/categorías/guardar")
    public String guardarCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
        return "redirect:/categorías";
    }

    @GetMapping("/categorías/editar/{id}")
    public String mostrarFormularioDeEditarCategoria(Model model, @PathVariable Integer id) {
        
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        model.addAttribute("categoria", categoria);
        return "categorias/categoria_form";
    }

    @GetMapping("/categorías/eliminar/{id}")
    public String eliminarCategoria(Model model, @PathVariable Integer id) {
        categoriaRepository.deleteById(id);
        return "redirect:/categorías";
    }
}