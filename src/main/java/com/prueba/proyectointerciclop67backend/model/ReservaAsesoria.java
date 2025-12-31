package com.prueba.proyectointerciclop67backend.model;


import jakarta.persistence.*;

@Entity
@Table (name="reserva_asesoria")
public class ReservaAsesoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="resa_id")
    private Integer id;
    @Column (name="resa_motivo")
    private String motivo;
    @Column (name="resa_estado")
    private String estado;
    @ManyToOne
    @JoinColumn (name="resa_id_asesoria")
    private Asesoria asesoria;
    @ManyToOne
    @JoinColumn (name="resa_id_hora_asesoria")
    private HoraAsesoria horaAsesoria;
    @ManyToOne
    @JoinColumn (name = "resa_id_solicitante")
    private Usuario solicitante;
    @ManyToOne
    @JoinColumn (name ="resa_id_programador")
    private Usuario programador;


    public ReservaAsesoria(){}

    public ReservaAsesoria(String motivo, Asesoria asesoria, HoraAsesoria horaAsesoria, Usuario solicitante, Usuario programador, String estado) {
        this.motivo = motivo;
        this.asesoria = asesoria;
        this.horaAsesoria = horaAsesoria;
        this.solicitante = solicitante;
        this.programador = programador;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Asesoria getAsesoria() {
        return asesoria;
    }

    public void setAsesoria(Asesoria asesoria) {
        this.asesoria = asesoria;
    }

    public HoraAsesoria getHoraAsesoria() {
        return horaAsesoria;
    }

    public void setHoraAsesoria(HoraAsesoria horaAsesoria) {
        this.horaAsesoria = horaAsesoria;
    }

    public Usuario getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Usuario solicitante) {
        this.solicitante = solicitante;
    }

    public Usuario getProgramador() {
        return programador;
    }

    public void setProgramador(Usuario programador) {
        this.programador = programador;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
