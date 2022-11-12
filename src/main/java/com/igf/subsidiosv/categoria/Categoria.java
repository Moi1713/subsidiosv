package com.igf.subsidiosv.categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String nombre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Categoria(Integer id) {
        super();
        this.id = id;
    }

    public Categoria(String nombre) {
        super();
        this.nombre = nombre;
    }

    public Categoria() {
        super();
    }

}


