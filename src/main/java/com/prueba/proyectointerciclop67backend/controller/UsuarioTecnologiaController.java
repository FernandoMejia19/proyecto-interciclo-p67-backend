package com.prueba.proyectointerciclop67backend.controller;

import com.prueba.proyectointerciclop67backend.model.Tecnologia;
import com.prueba.proyectointerciclop67backend.model.UsuarioTecnologia;
import com.prueba.proyectointerciclop67backend.repository.UsuarioRepository;
import com.prueba.proyectointerciclop67backend.repository.UsuarioTecnologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth/usuario-tecnologia")
public class UsuarioTecnologiaController {
    @Autowired
    private UsuarioTecnologiaRepository usuarioTecnologiaRepository;

    @GetMapping
    public List<UsuarioTecnologia> getAll(){
        return usuarioTecnologiaRepository.findAll();
    }

    @GetMapping("/id-usuario/{id}")
    public List<UsuarioTecnologia> getTecnologias(@PathVariable Integer id){
        return usuarioTecnologiaRepository.findByUsuario(id);
    }
}
