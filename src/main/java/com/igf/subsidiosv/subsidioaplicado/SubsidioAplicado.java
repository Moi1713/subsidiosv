package com.igf.subsidiosv.subsidioaplicado;

import javax.persistence.*;

import com.igf.subsidiosv.solicitud.Solicitud;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Entity
public class SubsidioAplicado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /*

    @Column(length = 50, nullable = false)
    private String beneficiario;

    @Column(length = 10, nullable = false)
    private String dui;

    @Column(length = 50, nullable = false)
    private String producto;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private double monto;

    @Column(nullable = false)
    private double total;

    @OneToOne
    @JoinColumn(name = "solicitud_id")
    private Solicitud solicitud;



    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setCategoria(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
     */

}
