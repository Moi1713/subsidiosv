package com.igf.subsidiosv.producto;

import com.igf.subsidiosv.categoria.Categoria;

import javax.persistence.*;

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
