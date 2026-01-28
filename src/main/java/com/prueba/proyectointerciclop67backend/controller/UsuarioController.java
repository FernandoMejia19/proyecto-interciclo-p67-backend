package com.prueba.proyectointerciclop67backend.controller;

import com.prueba.proyectointerciclop67backend.exception.ResourceNotFoundException;
import com.prueba.proyectointerciclop67backend.model.Usuario;
import com.prueba.proyectointerciclop67backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getClienteById (@PathVariable Integer id){
        Usuario u=usuarioRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No existe el Usuario con el ID" + id));
        return ResponseEntity.ok(u);
    }
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Usuario> getClienteByName(@PathVariable String nombre){
        Usuario u = usuarioRepository.findByNombre(nombre).orElseThrow(()-> new ResourceNotFoundException("No existe el Usuario con el nombre" + nombre));
        return ResponseEntity.ok(u);
    }
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario u){
        return usuarioRepository.save(u);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> eliminar(@PathVariable Integer id){
        if(!usuarioRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
