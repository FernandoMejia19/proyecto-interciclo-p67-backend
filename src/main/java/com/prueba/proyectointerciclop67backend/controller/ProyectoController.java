package com.prueba.proyectointerciclop67backend.controller;

import com.prueba.proyectointerciclop67backend.model.Proyecto;
import com.prueba.proyectointerciclop67backend.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {
    @Autowired
    private ProyectoRepository proyectoRepository;

    @GetMapping
    public List<Proyecto> getAll(){
        return proyectoRepository.findAll();
    }
}
