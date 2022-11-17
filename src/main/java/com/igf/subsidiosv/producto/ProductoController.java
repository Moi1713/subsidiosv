package com.igf.subsidiosv.producto;

import com.igf.subsidiosv.categoria.Categoria;
import com.igf.subsidiosv.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;

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
    public String guardarProducto(Producto producto) {
        productoRepository.save(producto);

        return "redirect:/productos";
    }
 @GetMapping("/editarproductos/{id}")
    public String mostrarFormularioDeEditarProducto(Model model, @PathVariable Integer id) {
        List<Categoria> listaCategorias=categoriaRepository.findAll();
        Optional<Producto> producto = productoRepository.findById(id);
        model.addAttribute("listaCategorias", listaCategorias);
        model.addAttribute("producto", producto);
        return "productos/producto_form";
    }
    @GetMapping("/eliminarproductos/{id}")
    public String eliminarProducto(Model model, @PathVariable Integer id) {
        productoRepository.deleteById(id);
        return "redirect:/productos";
    }
}
