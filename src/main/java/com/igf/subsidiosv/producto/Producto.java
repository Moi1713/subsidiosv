package com.igf.subsidiosv.producto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.igf.subsidiosv.categoria.Categoria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 50, nullable = false)
    private String marca;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @Column(nullable = false)
    private double precio;

    public Producto(Integer id) {
        super();
        this.id = id;
    }

    public Producto(Categoria categoria) {
        super();
        this.categoria = categoria;
    }

    public Producto(double precio) {
        super();
        this.precio = precio;
    }
    
}
