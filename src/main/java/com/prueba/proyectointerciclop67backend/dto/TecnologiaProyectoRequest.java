package com.prueba.proyectointerciclop67backend.dto;

public class TecnologiaProyectoRequest {
    private Integer idProyecto;
    private String tecnologia;

    public TecnologiaProyectoRequest(){}

    public TecnologiaProyectoRequest(Integer idProyecto, String tecnologia) {
        this.idProyecto = idProyecto;
        this.tecnologia = tecnologia;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }
}
