package pe.edu.upc.vwalletweb.dtos;


import pe.edu.upc.vwalletweb.entities.Servicios;

public class CafeteriaDTO {
    private int idCafeteria;

    private String sedeCafeteria;

    private Servicios servicios;

    public int getIdCafeteria() {
        return idCafeteria;
    }

    public void setIdCafeteria(int idCafeteria) {
        this.idCafeteria = idCafeteria;
    }

    public String getSedeCafeteria() {
        return sedeCafeteria;
    }

    public void setSedeCafeteria(String sedeCafeteria) {
        this.sedeCafeteria = sedeCafeteria;
    }

    public Servicios getServicios() {
        return servicios;
    }

    public void setServicios(Servicios servicios) {
        this.servicios = servicios;
    }
}
