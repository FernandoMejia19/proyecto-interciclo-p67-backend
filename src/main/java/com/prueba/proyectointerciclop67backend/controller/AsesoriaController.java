package com.prueba.proyectointerciclop67backend.controller;

import com.prueba.proyectointerciclop67backend.model.Asesoria;
import com.prueba.proyectointerciclop67backend.repository.AsesoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/asesorias")
public class AsesoriaController {
    @Autowired
    private AsesoriaRepository asesoriaRepository;

    @GetMapping
    public List<Asesoria> getAll(){
        return asesoriaRepository.findAll();
    }
}
