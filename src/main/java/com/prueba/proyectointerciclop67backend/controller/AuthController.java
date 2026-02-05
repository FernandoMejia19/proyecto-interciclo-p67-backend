package com.prueba.proyectointerciclop67backend.controller;

import com.prueba.proyectointerciclop67backend.dto.LoginRequest;
import com.prueba.proyectointerciclop67backend.dto.LoginResponse;
import com.prueba.proyectointerciclop67backend.dto.RegistroUsuarioDTO;
import com.prueba.proyectointerciclop67backend.model.Usuario;
import com.prueba.proyectointerciclop67backend.repository.UsuarioRepository;
import com.prueba.proyectointerciclop67backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //  REGISTRO
    @PostMapping("/registrar")
    public ResponseEntity<?> registrarUsuario(@RequestBody RegistroUsuarioDTO dto) {

        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        usuario.setContrasena(dto.getPassword());
        usuario.setRol(dto.getRol());

        Usuario guardado = usuarioService.guardarUsuario(usuario);

        return ResponseEntity.ok(guardado);
    }

    //  LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        Usuario usuario = usuarioService.buscarPorEmail(loginRequest.getEmail());
        if (!passwordEncoder.matches(loginRequest.getContrasena(), usuario.getContrasena())) {
            return ResponseEntity.status(401).body("Usuario o contraseña incorrectos");
        }

        LoginResponse response = new LoginResponse();
        response.setId(usuario.getId());
        response.setNombre(usuario.getNombre());
        response.setEmail(usuario.getEmail());
        response.setRol(usuario.getRol());
        response.setFoto(usuario.getFoto());

        return ResponseEntity.ok(response);
    }


}
