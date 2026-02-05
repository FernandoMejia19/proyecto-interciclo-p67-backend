package com.prueba.proyectointerciclop67backend.dto;

public class DashboardStatsResponse {

    private long totalProyectos;
    private long totalUsuarios;

    public DashboardStatsResponse(long totalProyectos, long totalUsuarios) {
        this.totalProyectos = totalProyectos;
        this.totalUsuarios = totalUsuarios;
    }

    public long getTotalProyectos() {
        return totalProyectos;
    }

    public long getTotalUsuarios() {
        return totalUsuarios;
    }
}
