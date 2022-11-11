package com.igf.subsidiosv.producto;

import com.igf.subsidiosv.categoria.Categoria;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
