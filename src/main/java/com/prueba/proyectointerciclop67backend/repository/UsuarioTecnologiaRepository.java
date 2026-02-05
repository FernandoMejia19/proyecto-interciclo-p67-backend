package com.prueba.proyectointerciclop67backend.repository;

import com.prueba.proyectointerciclop67backend.model.UsuarioTecnologia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioTecnologiaRepository extends JpaRepository<UsuarioTecnologia,Integer> {
    List<UsuarioTecnologia> findByUsuario(Integer integer);
}
