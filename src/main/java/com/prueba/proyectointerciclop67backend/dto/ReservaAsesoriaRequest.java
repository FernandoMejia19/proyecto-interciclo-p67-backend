package com.prueba.proyectointerciclop67backend.dto;

public class ReservaAsesoriaRequest {
    private String motivo;
    private String estado="pendiente";
    private Integer idAsesoria;
    private Integer idHoraAsesoria;
    private Integer idSolicitante;
    private Integer idProgramador;

    private ReservaAsesoriaRequest(){}

    public ReservaAsesoriaRequest(String motivo, String estado, Integer idAsesoria, Integer idHoraAsesoria, Integer idSolicitante, Integer idProgramador) {
        this.motivo = motivo;
        this.estado = estado;
        this.idAsesoria = idAsesoria;
        this.idHoraAsesoria = idHoraAsesoria;
        this.idSolicitante = idSolicitante;
        this.idProgramador = idProgramador;
    }
    public ReservaAsesoriaRequest(String motivo,String estado){
        this.motivo=motivo;
        this.estado=estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getIdAsesoria() {
        return idAsesoria;
    }

    public void setIdAsesoria(Integer idAsesoria) {
        this.idAsesoria = idAsesoria;
    }

    public Integer getIdHoraAsesoria() {
        return idHoraAsesoria;
    }

    public void setIdHoraAsesoria(Integer idHoraAsesoria) {
        this.idHoraAsesoria = idHoraAsesoria;
    }

    public Integer getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(Integer idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public Integer getIdProgramador() {
        return idProgramador;
    }

    public void setIdProgramador(Integer idProgramador) {
        this.idProgramador = idProgramador;
    }
}
