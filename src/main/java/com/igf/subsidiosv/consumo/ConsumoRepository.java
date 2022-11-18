package com.igf.subsidiosv.consumo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConsumoRepository extends JpaRepository<Consumo,Integer>{

    @Query("select b.consumo from Consumo b where b.periodo = (SELECT max(s.periodo) FROM Consumo s WHERE s.dui = ?1)")
    public Integer findConsumo(String dui);


}