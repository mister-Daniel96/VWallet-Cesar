package pe.edu.upc.vwalletweb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Servicios")
public class Servicios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServicios;
    @Column(name = "nombreServicio",nullable = false,length = 100)
    private String nombreServicio;
    @Column(name = "estado",nullable = false,length = 100)
    private String estado;

    public Servicios() {
    }

    public Servicios(int idServicios, String nombreServicio, String estado) {
        this.idServicios = idServicios;
        this.nombreServicio = nombreServicio;
        this.estado = estado;
    }

    public int getIdServicios() {
        return idServicios;
    }

    public void setIdServicios(int idServicios) {
        this.idServicios = idServicios;
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
