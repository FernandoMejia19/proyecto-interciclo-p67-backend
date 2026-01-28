package com.prueba.proyectointerciclop67backend.repository;

import com.prueba.proyectointerciclop67backend.model.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TecnologiaRepository extends JpaRepository<Tecnologia,Integer> {
    Tecnologia findTecnologiaByNombre(String nombre);

    Optional<Tecnologia> findByNombreIgnoreCase(String nombre);

    boolean existsTecnologiaByNombre(String nombre);
}
