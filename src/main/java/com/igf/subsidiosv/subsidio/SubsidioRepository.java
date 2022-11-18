package com.igf.subsidiosv.subsidio;

import com.igf.subsidiosv.solicitud.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubsidioRepository extends JpaRepository<Subsidio,Integer>{

    @Query("SELECT s FROM Subsidio s WHERE s.producto.id = ?1 and s.beneficio.id  =?2")
    public Subsidio findSubsidio(Integer idProducto,Integer idBeneficio);

}
