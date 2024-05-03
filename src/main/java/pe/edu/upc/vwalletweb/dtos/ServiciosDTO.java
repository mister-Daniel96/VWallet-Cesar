package pe.edu.upc.vwalletweb.dtos;

import jakarta.persistence.Column;

public class ServiciosDTO {

    private int idServicios;

    private String nombreServicio;

    private String estado;

    public int getIdServicio() {
        return idServicios;
    }

    public void setIdServicio(int idServicio) {
        this.idServicios = idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
