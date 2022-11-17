package com.igf.subsidiosv.consumo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.igf.subsidiosv.empresa.Empresa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Calendar;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import java.time.LocalDate;
import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Consumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10, nullable = false)
    private String dui;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @Column(nullable = false)
    private Integer consumo;

    @Column
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    private Date periodo;
    
}