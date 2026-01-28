package com.prueba.proyectointerciclop67backend.controller;

import com.prueba.proyectointerciclop67backend.exception.ResourceNotFoundException;
import com.prueba.proyectointerciclop67backend.model.Tecnologia;
import com.prueba.proyectointerciclop67backend.repository.TecnologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tecnologias")
public class TecnologiaController {
    @Autowired
    private TecnologiaRepository tecnologiaRepository;

    @GetMapping
    public List<Tecnologia> getAll(){
        return tecnologiaRepository.findAll();
    }
    @PostMapping("/find-or-create")
    public ResponseEntity<?> findOrCreateTecnologia(@RequestBody Tecnologia request) {

        // Validación básica
        if (request.getNombre() == null || request.getNombre().trim().isEmpty()) {
            return ResponseEntity.badRequest()
                    .body("El nombre es requerido");
        }

        String nombreBusqueda = request.getNombre().trim();

        // 1. Primero intentar buscar
        Optional<Tecnologia> existente = tecnologiaRepository
                .findByNombreIgnoreCase(nombreBusqueda);

        if (existente.isPresent()) {
            // Ya existe - retornar 200
            return ResponseEntity.ok(existente.get());
        }

        // 2. No existe - crear nueva
        Tecnologia nueva = new Tecnologia();
        nueva.setNombre(nombreBusqueda);

        try {
            Tecnologia guardada = tecnologiaRepository.save(nueva);
            return ResponseEntity.status(HttpStatus.CREATED).body(guardada);
        } catch (DataIntegrityViolationException e) {
            // En caso de concurrencia, alguien más pudo crearla
            return tecnologiaRepository.findByNombreIgnoreCase(nombreBusqueda)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
        }
    }
}
