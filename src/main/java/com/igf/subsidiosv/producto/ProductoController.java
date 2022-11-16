package com.igf.subsidiosv.producto;

import com.igf.subsidiosv.categoria.Categoria;
import com.igf.subsidiosv.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/productos")
    public String listarProductos(Model model) {
        List<Producto> listaProductos = productoRepository.findAll();
        model.addAttribute("listaProductos", listaProductos);

        return "productos/producto";
    }

    @GetMapping("/productos/nuevo")
    public String mostrarFormularioDeNuevoProducto(Model model) {
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        model.addAttribute("producto", new Producto());
        model.addAttribute("listaCategorias", listaCategorias);

        return "productos/producto_form";
    }

    @PostMapping("/productos/guardar")
    public String guardarUsuario(Producto producto) {
        productoRepository.save(producto);

        return "redirect:/productos";
    }

    // TODO implementar opciones para editar y eliminar un producto.
}
