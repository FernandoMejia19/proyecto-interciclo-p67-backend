package com.prueba.proyectointerciclop67backend.controller;

import com.prueba.proyectointerciclop67backend.model.HoraAsesoria;
import com.prueba.proyectointerciclop67backend.repository.HoraAsesoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hora-asesoria")
public class HoraAsesoriaController {
    @Autowired
    private HoraAsesoriaRepository horaAsesoriaRepository;
    @GetMapping
    public List<HoraAsesoria> getAllHoras(){
        return horaAsesoriaRepository.findAll();
    }
}
