package com.igf.subsidiosv.subsidioaplicado;

import javax.persistence.*;
import java.util.Date;

import com.igf.subsidiosv.solicitud.Solicitud;
import com.igf.subsidiosv.beneficiario.Beneficiario;
import com.igf.subsidiosv.producto.Producto;
import com.igf.subsidiosv.beneficio.Beneficio;
import com.igf.subsidiosv.subsidio.Subsidio;

import org.springframework.format.annotation.DateTimeFormat;

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

    @OneToOne
    @JoinColumn(name = "solicitud_id")
    private Solicitud solicitud;

    @ManyToOne
    @JoinColumn(name = "beneficiario_id")
    private Beneficiario beneficiario;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "subsidio_id")
    private Subsidio subsidio;

    @Column(nullable = false)
    private double total;

    @ManyToOne
    @JoinColumn(name = "beneficio_id")
    private Beneficio beneficio;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fecha_registro;

}
