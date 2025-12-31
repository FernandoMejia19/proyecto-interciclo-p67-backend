package com.prueba.proyectointerciclop67backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name="asesorias")
public class Asesoria {
    @Id
    @Column (name="ases_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (name="ases_fecha")
    private LocalDate fecha;
    @ManyToOne
    @JoinColumn (name="ases_id_programador_fk")
    private Usuario programador;
    public Asesoria(){}

    public Asesoria(Integer id, LocalDate fecha, Usuario programador) {
        this.id = id;
        this.fecha = fecha;
        this.programador = programador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Usuario getProgramador() {
        return programador;
    }

    public void setProgramador(Usuario programador) {
        this.programador = programador;
    }
}
