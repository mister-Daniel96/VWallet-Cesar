package pe.edu.upc.vwalletweb.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "cafeteria")
public class Cafeteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCafeteria;
    @Column(name = "sedeCafeteria",nullable = false,length = 100)
    private String sedeCafeteria;
    @ManyToOne
    @JoinColumn(name = "servicios_id")
    private Servicios servicios;

    public Cafeteria() {
    }

    public Cafeteria(int idCafeteria, String sedeCafeteria, Servicios servicios) {
        this.idCafeteria = idCafeteria;
        this.sedeCafeteria = sedeCafeteria;
        this.servicios = servicios;
    }

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
