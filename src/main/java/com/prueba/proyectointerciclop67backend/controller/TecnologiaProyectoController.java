package com.prueba.proyectointerciclop67backend.controller;

import com.prueba.proyectointerciclop67backend.dto.TecnologiaProyectoRequest;
import com.prueba.proyectointerciclop67backend.exception.ResourceNotFoundException;
import com.prueba.proyectointerciclop67backend.model.Proyecto;
import com.prueba.proyectointerciclop67backend.model.Tecnologia;
import com.prueba.proyectointerciclop67backend.model.TecnologiaProyecto;
import com.prueba.proyectointerciclop67backend.repository.ProyectoRepository;
import com.prueba.proyectointerciclop67backend.repository.TecnologiaProyectoRepository;
import com.prueba.proyectointerciclop67backend.repository.TecnologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tecnologia-proyecto")
public class TecnologiaProyectoController {
    @Autowired
    private TecnologiaProyectoRepository tecnologiaProyectoRepository;
    @Autowired
    private ProyectoRepository proyectoRepository;
    private TecnologiaController tecnologiaController;
    @Autowired
    private TecnologiaRepository tecnologiaRepository;
    @GetMapping
    public List<TecnologiaProyecto> getAll() {
        return tecnologiaProyectoRepository.findAll();
    }
    @PostMapping
    public ResponseEntity<TecnologiaProyecto> crearTecnologiaProyecto(
            @RequestBody TecnologiaProyectoRequest request) {

        Proyecto proyecto = proyectoRepository.findById(request.getIdProyecto())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "No se encontró el proyecto con ID: " + request.getIdProyecto()
                ));

        Tecnologia tecnologia;
        Optional<Tecnologia> tecnologiaExistente = tecnologiaRepository
                .findByNombreIgnoreCase((request.getTecnologia().trim()));

        if (tecnologiaExistente.isPresent()) {
            tecnologia = tecnologiaExistente.get();
        } else {
            Tecnologia nuevaTecnologia = new Tecnologia();
            nuevaTecnologia.setNombre(request.getTecnologia().trim());
            tecnologia = tecnologiaRepository.save(nuevaTecnologia);
        }
        TecnologiaProyecto tecnologiaProyecto = new TecnologiaProyecto();
        tecnologiaProyecto.setProyecto(proyecto);
        tecnologiaProyecto.setTecnologia(tecnologia);

        TecnologiaProyecto guardarTecProy = tecnologiaProyectoRepository.save(tecnologiaProyecto);

        return ResponseEntity.status(HttpStatus.CREATED).body(guardarTecProy);
    }

}
