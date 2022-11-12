package com.igf.subsidiosv.solicitud;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.igf.subsidiosv.producto.Producto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 25, nullable = false)
    private String dui;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @Column(length = 25, nullable = false)
    private String clave;

    @Column(length = 25, nullable = false)
    private String estado;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fecha_ingreso;
}
