package com.prueba.proyectointerciclop67backend.model;

import jakarta.persistence.*;

@Entity
@Table(name="usuario_tecnologia")
public class UsuarioTecnologia {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="usutec_id")
    private Integer idUsuTecnologia;
    @ManyToOne
    @JoinColumn(name= "usutec_usuario_id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn (name="usutec_tecnologia_id")
    private Tecnologia tecnologia;

    public UsuarioTecnologia(){ }

    public UsuarioTecnologia(Integer idUsuTecnologia, Usuario usuario, Tecnologia tecnologia) {
        this.idUsuTecnologia = idUsuTecnologia;
        this.usuario = usuario;
        this.tecnologia = tecnologia;
    }

    public Integer getIdUsuTecnologia() {
        return idUsuTecnologia;
    }

    public void setIdUsuTecnologia(Integer idUsuTecnologia) {
        this.idUsuTecnologia = idUsuTecnologia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tecnologia getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(Tecnologia tecnologia) {
        this.tecnologia = tecnologia;
    }
}
