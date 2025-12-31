package com.prueba.proyectointerciclop67backend.controller;

import com.prueba.proyectointerciclop67backend.model.UsuarioTecnologia;
import com.prueba.proyectointerciclop67backend.repository.UsuarioRepository;
import com.prueba.proyectointerciclop67backend.repository.UsuarioTecnologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario-tecnologia")
public class UsuarioTecnologiaController {
    @Autowired
    private UsuarioTecnologiaRepository usuarioTecnologiaRepository;
    @GetMapping
    public List<UsuarioTecnologia> getAll(){
        return usuarioTecnologiaRepository.findAll();
    }
}
