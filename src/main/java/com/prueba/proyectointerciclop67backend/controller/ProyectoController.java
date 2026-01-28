package com.prueba.proyectointerciclop67backend.controller;

import com.prueba.proyectointerciclop67backend.dto.ProyectoRequest;
import com.prueba.proyectointerciclop67backend.exception.ResourceNotFoundException;
import com.prueba.proyectointerciclop67backend.model.Proyecto;
import com.prueba.proyectointerciclop67backend.model.Usuario;
import com.prueba.proyectointerciclop67backend.repository.ProyectoRepository;
import com.prueba.proyectointerciclop67backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {
    @Autowired
    private ProyectoRepository proyectoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Proyecto> getAll(){
        return proyectoRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> getProyectoById(@PathVariable Integer id){
        Proyecto proyecto=proyectoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No se encontro el proyecto"));
        return ResponseEntity.ok(proyecto);
    }

    @PostMapping
    public ResponseEntity<Proyecto> crearProyecto(@RequestBody ProyectoRequest request){
        Usuario programador=usuarioRepository.findById(request.getIdProgramador()).orElseThrow(()-> new ResourceNotFoundException("No se encontro la Proyecto"));
        Proyecto proyecto=new Proyecto();
        proyecto.setTitulo(request.getTitulo());
        proyecto.setDescripcion(request.getDescripcion());
        proyecto.setImagen(request.getImagen());
        proyecto.setLinkRepo(request.getLinkRepo());
        proyecto.setProgramador(programador);
        proyecto.setFecha(request.getFecha());
        Proyecto guardarProyecto=proyectoRepository.save(proyecto);
        return ResponseEntity.ok(guardarProyecto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Proyecto> eliminar(@PathVariable Integer id){
        if(!proyectoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        proyectoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyecto> actualizarProyecto(@PathVariable Integer id,@RequestBody ProyectoRequest request){
        Proyecto datosProyecto=proyectoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No existe el proyecto"));
        if(request.getTitulo() != null){
            datosProyecto.setTitulo(request.getTitulo());
        }

        if(request.getDescripcion() != null){
            datosProyecto.setDescripcion(request.getDescripcion());
        }

        if(request.getImagen() != null){
            datosProyecto.setImagen(request.getImagen());
        }

        if(request.getLinkRepo() != null){
            datosProyecto.setLinkRepo(request.getLinkRepo());
        }
        Proyecto proyectoActualizado=proyectoRepository.save(datosProyecto);
        return ResponseEntity.ok(proyectoActualizado);
    }
}
