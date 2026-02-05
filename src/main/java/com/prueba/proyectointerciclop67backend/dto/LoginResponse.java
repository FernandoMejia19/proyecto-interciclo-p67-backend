package com.prueba.proyectointerciclop67backend.dto;

public class LoginResponse {
    private Integer id;
    private String nombre;
    private String email;
    private String rol;
    private String foto;

    public LoginResponse(){

    }

    public LoginResponse(Integer id, String nombre, String email, String rol, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
        this.foto = foto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
