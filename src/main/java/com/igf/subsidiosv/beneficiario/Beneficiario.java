package com.igf.subsidiosv.beneficiario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.igf.subsidiosv.beneficio.Beneficio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Beneficiario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 25, nullable = false)
    private String dui;

    @Column(length = 300, nullable = false)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "beneficio_id")
    private Beneficio beneficio;

    @Column(length = 25, nullable = false)
    private String clave;
}
