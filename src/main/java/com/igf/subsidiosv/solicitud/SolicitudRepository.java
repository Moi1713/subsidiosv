package com.igf.subsidiosv.solicitud;

import com.igf.subsidiosv.beneficiario.Beneficiario;
import com.igf.subsidiosv.consumo.Consumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SolicitudRepository extends JpaRepository<Solicitud,Integer>{

    @Query("select b from Beneficiario b where b.dui = (SELECT s.dui FROM Solicitud s WHERE s.id = ?1)")
    public Beneficiario findSolicitudBeneficiario( Integer id);

    @Query("SELECT s FROM Solicitud s WHERE s.id = ?1")
    public Solicitud findSolicitud( Integer id);

}