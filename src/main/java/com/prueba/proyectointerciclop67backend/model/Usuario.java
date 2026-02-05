package com.prueba.proyectointerciclop67backend.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @Column(name="usu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="usu_nombre")
    private String nombre;
    @Column(name="usu_ciudad")
    private String ciudad;
    @Column (name="usu_pais")
    private String pais;
    @Column (name="usu_descripcion")
    private String descripcion;
    @Column (name="usu_facebook")
    private String facebook;
    @Column (name="usu_linkedin")
    private String linkedin;
    @Column (name="usu_celular")
    private String celular;
    @Column (name="usu_github")
    private String github;
    @Column (name="usu_email")
    private String email;
    @JsonIgnore //no va a enviar al front
    @Column (name="usu_contrasena")
    private String contrasena;
    @Column (name="usu_rol")
    private String rol;
    @Column(name = "usu_fotoperfil")
    private String foto;
    @JsonIgnore
    @OneToMany(mappedBy = "programador")
    private List<Proyecto> proyectos;


    public Usuario(){

    }

    public Usuario(String nombre, String ciudad, String pais, String descripcion, String facebook, String linkedin, String celular, String github, String email, String contrasena, String rol, String foto, List<Proyecto> proyectos) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.descripcion = descripcion;
        this.facebook = facebook;
        this.linkedin = linkedin;
        this.celular = celular;
        this.github = github;
        this.email = email;
        this.contrasena = contrasena;
        this.rol = rol;
        this.foto = foto;
        this.proyectos = proyectos;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
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

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
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

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
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
