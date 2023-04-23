package com.example.lab4_20191792.Repository;

import com.example.lab4_20191792.Entity.Aerolinea;
import com.example.lab4_20191792.Entity.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VueloRepository extends JpaRepository<Vuelo, Integer> {



}