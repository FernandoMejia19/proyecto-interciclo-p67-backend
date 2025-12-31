package com.prueba.proyectointerciclop67backend.controller;

import com.prueba.proyectointerciclop67backend.model.ReservaAsesoria;
import com.prueba.proyectointerciclop67backend.repository.ReservaAsesoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaAsesoriaController {
    @Autowired
    private ReservaAsesoriaRepository reservaAsesoriaRepository;
    @GetMapping
    public List<ReservaAsesoria> getAll (){
        return reservaAsesoriaRepository.findAll();
    }
}
