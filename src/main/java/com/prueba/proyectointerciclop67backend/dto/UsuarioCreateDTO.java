package com.prueba.proyectointerciclop67backend.dto;

public class UsuarioCreateDTO {
    private String nombre;
    private String email;
    private String password;
    private String rol;
    private String ciudad;
    private String pais;
    private String descripcion;
    private String github;
    private String linkedin;
    private String celular;
    private String foto;

    public UsuarioCreateDTO() {
    }

    public UsuarioCreateDTO(String nombre, String email, String password, String rol, String ciudad, String pais, String descripcion, String github, String linkedin, String celular, String foto) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.ciudad = ciudad;
        this.pais = pais;
        this.descripcion = descripcion;
        this.github = github;
        this.linkedin = linkedin;
        this.celular = celular;
        this.foto = foto;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
