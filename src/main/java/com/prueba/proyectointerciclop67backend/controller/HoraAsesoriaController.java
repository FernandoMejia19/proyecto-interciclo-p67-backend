package com.prueba.proyectointerciclop67backend.controller;

import com.prueba.proyectointerciclop67backend.dto.HoraAsesoriaRequest;
import com.prueba.proyectointerciclop67backend.exception.ResourceNotFoundException;
import com.prueba.proyectointerciclop67backend.model.Asesoria;
import com.prueba.proyectointerciclop67backend.model.HoraAsesoria;
import com.prueba.proyectointerciclop67backend.repository.AsesoriaRepository;
import com.prueba.proyectointerciclop67backend.repository.HoraAsesoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hora-asesoria")
public class HoraAsesoriaController {
    @Autowired
    private HoraAsesoriaRepository horaAsesoriaRepository;
    @Autowired
    private AsesoriaRepository asesoriaRepository;
    @GetMapping
    public List<HoraAsesoria> getAll(){
        return horaAsesoriaRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<HoraAsesoria> getHoraById(@PathVariable Integer id){
        HoraAsesoria hora=horaAsesoriaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No hay una hora"));
        return ResponseEntity.ok(hora);
    }

    @PostMapping
    public ResponseEntity<HoraAsesoria> crearHoraAsesoria(@RequestBody HoraAsesoriaRequest request){
        Asesoria asesoria=asesoriaRepository.findById(request.getIdAsesoria()).orElseThrow(()->new ResourceNotFoundException("No se encontro la Asesoria"));
        HoraAsesoria hora=new HoraAsesoria();
        hora.setHora(request.getHora());
        hora.setReservado(request.getReservado());
        hora.setAsesoria(asesoria);
        HoraAsesoria gurdarHora=horaAsesoriaRepository.save(hora);
        return ResponseEntity.ok(gurdarHora);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HoraAsesoria> eliminar(@PathVariable Integer id){
        if(!horaAsesoriaRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        horaAsesoriaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<HoraAsesoria> actualizarHoraAsesoria(@PathVariable Integer id,@RequestBody HoraAsesoriaRequest request){
        HoraAsesoria datosHora=horaAsesoriaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No existe la hora de asesoria"));
        if(request.getIdAsesoria()!=null){
            Asesoria asesoria=asesoriaRepository.findById(request.getIdAsesoria()).orElseThrow(()->new ResourceNotFoundException("No se encontro la asesoria"));
            datosHora.setAsesoria(asesoria);
        }
        if(request.getHora() !=null){
            datosHora.setHora(request.getHora());
            datosHora.setReservado(request.getReservado());
        }
        HoraAsesoria horaActualizada=horaAsesoriaRepository.save(datosHora);
        return ResponseEntity.ok(horaActualizada);
    }
}
