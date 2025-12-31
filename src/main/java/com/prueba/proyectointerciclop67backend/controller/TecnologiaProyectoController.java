package com.prueba.proyectointerciclop67backend.controller;

import com.prueba.proyectointerciclop67backend.model.TecnologiaProyecto;
import com.prueba.proyectointerciclop67backend.repository.TecnologiaProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tecnologia-proyecto")
public class TecnologiaProyectoController {
    @Autowired
    private TecnologiaProyectoRepository tecnologiaProyectoRepository;
    @GetMapping
    public List<TecnologiaProyecto> getAll() {
        return tecnologiaProyectoRepository.findAll();
    }
}
