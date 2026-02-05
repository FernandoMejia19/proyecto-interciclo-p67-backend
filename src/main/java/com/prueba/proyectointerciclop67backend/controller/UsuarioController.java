package com.prueba.proyectointerciclop67backend.controller;

import com.prueba.proyectointerciclop67backend.dto.UsuarioCreateDTO;
import com.prueba.proyectointerciclop67backend.exception.ResourceNotFoundException;
import com.prueba.proyectointerciclop67backend.model.Usuario;
import com.prueba.proyectointerciclop67backend.repository.UsuarioRepository;
import com.prueba.proyectointerciclop67backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    PasswordEncoder encoder;

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtener(@PathVariable Integer id) {
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }

    @PostMapping
    public Usuario crear(@RequestBody UsuarioCreateDTO dto) {
        System.out.println("PASSWORD RECIBIDO 👉 " + dto.getPassword());
        Usuario u = new Usuario();
        u.setNombre(dto.getNombre());
        u.setEmail(dto.getEmail());
        u.setRol(dto.getRol());
        u.setCiudad(dto.getCiudad());
        u.setPais(dto.getPais());
        u.setDescripcion(dto.getDescripcion());
        u.setGithub(dto.getGithub());
        u.setLinkedin(dto.getLinkedin());
        u.setCelular(dto.getCelular());
        u.setContrasena(dto.getPassword());
        u.setFoto(dto.getFoto());

        return usuarioService.guardarUsuario(u);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        usuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(
            @PathVariable Integer id,
            @RequestBody Usuario usuarioActualizado
    ) {
        Usuario usuario = usuarioService.buscarPorId(id);

        if (usuarioActualizado.getNombre() != null) {
            usuario.setNombre(usuarioActualizado.getNombre());
        }
        if (usuarioActualizado.getCiudad() != null) {
            usuario.setCiudad(usuarioActualizado.getCiudad());
        }
        if (usuarioActualizado.getPais() != null) {
            usuario.setPais(usuarioActualizado.getPais());
        }
        if (usuarioActualizado.getDescripcion() != null) {
            usuario.setDescripcion(usuarioActualizado.getDescripcion());
        }
        if (usuarioActualizado.getFacebook() != null) {
            usuario.setFacebook(usuarioActualizado.getFacebook());
        }
        if (usuarioActualizado.getCelular() != null) {
            usuario.setCelular(usuarioActualizado.getCelular());
        }
        if (usuarioActualizado.getLinkedin() != null) {
            usuario.setLinkedin(usuarioActualizado.getLinkedin());
        }
        if (usuarioActualizado.getGithub() != null) {
            usuario.setGithub(usuarioActualizado.getGithub());
        }

        Usuario guardado = usuarioService.guardar(usuario);
        return ResponseEntity.ok(guardado);
    }


    @GetMapping("/test-pass")
    public String test() {
        return encoder.encode("1234");
    }

}

