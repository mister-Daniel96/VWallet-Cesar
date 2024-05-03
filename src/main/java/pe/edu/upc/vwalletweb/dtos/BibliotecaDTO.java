package pe.edu.upc.vwalletweb.dtos;

import pe.edu.upc.vwalletweb.entities.Servicios;

public class BibliotecaDTO {
    private int idBiblioteca;

    private String sedeBiblioteca;

    private Servicios servicios;

    public int getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(int idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    public String getSedeBiblioteca() {
        return sedeBiblioteca;
    }

    public void setSedeBiblioteca(String sedeBiblioteca) {
        this.sedeBiblioteca = sedeBiblioteca;
    }

    public Servicios getServicios() {
        return servicios;
    }

    public void setServicios(Servicios servicios) {
        this.servicios = servicios;
    }
}
