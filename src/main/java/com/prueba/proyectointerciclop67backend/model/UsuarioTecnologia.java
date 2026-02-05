package com.prueba.proyectointerciclop67backend.model;

import jakarta.persistence.*;

@Entity
@Table(name="usuario_tecnologia")
public class UsuarioTecnologia {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="usutec_id")
    private Integer idUsuTecnologia;
    @Column(name= "usutec_usuario_id")
    private Integer usuario;
    @ManyToOne
    @JoinColumn (name="usutec_tecnologia_id")
    private Tecnologia tecnologia;

    public UsuarioTecnologia(){ }

    public UsuarioTecnologia( Integer idUsuario, Tecnologia tecnologia) {

        this.usuario = idUsuario;
        this.tecnologia = tecnologia;
    }

    public Integer getIdUsuTecnologia() {
        return idUsuTecnologia;
    }

    public void setIdUsuTecnologia(Integer idUsuTecnologia) {
        this.idUsuTecnologia = idUsuTecnologia;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public Tecnologia getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(Tecnologia tecnologia) {
        this.tecnologia = tecnologia;
    }
}
