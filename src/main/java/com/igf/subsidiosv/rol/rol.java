package com.igf.subsidiosv.rol;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String nombre;


    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rol() {
        super();
    }

    public Rol(Integer id, String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;
    }

    public Rol(Integer id) {
        super();
        this.id = id;
    }

    public Rol(String nombre) {
        super();
        this.nombre = nombre;
    }

}
