package com.prueba.proyectointerciclop67backend.controller;

import com.prueba.proyectointerciclop67backend.model.Tecnologia;
import com.prueba.proyectointerciclop67backend.repository.TecnologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tecnologias")
public class TecnologiaController {
    @Autowired
    private TecnologiaRepository tecnologiaRepository;
    @GetMapping
    public List<Tecnologia> getAll (){
        return tecnologiaRepository.findAll();
    }
}
