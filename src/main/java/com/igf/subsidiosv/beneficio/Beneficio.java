package com.igf.subsidiosv.beneficio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Beneficio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String nombre;

    public Beneficio(Integer id) {
        super();
        this.id = id;
    }

    public Beneficio(String nombre) {
        super();
        this.nombre = nombre;
    }

    
}


