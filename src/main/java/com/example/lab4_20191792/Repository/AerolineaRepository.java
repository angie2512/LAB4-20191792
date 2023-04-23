package com.example.lab4_20191792.Repository;

import com.example.lab4_20191792.Entity.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AerolineaRepository extends JpaRepository<Aerolinea, Integer> {


    @Query(value= "SELECT aerolinea.idaerolinea, aerolinea.nombre, aerolinea.codigo FROM vuelo INNER JOIN aerolinea WHERE vuelo.aerolinea_idaerolinea = aerolinea.idaerolinea ORDER BY idvuelo ASC", nativeQuery = true)
    List<Aerolinea> aerolinea();

}