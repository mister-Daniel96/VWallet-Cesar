package pe.edu.upc.vwalletweb.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "transporte")
public class Transporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTransporte;
    @Column(name = "universidadSalida",nullable = false,length = 100)
    private String universidadSalida;
    @Column(name = "universidadLlegada",nullable = false,length = 100)
    private String universidadLlegada;
    @Column(name = "horaSalida",nullable = false)
    private LocalDateTime horaSalida;
    @Column(name = "horaLlegada",nullable = false)
    private LocalDateTime horaLlegada;
    @Column(name = "precioTransporte",nullable = false)
    private float precioTransporte;
    @ManyToOne
    @JoinColumn(name = "servicios_id")
    private Servicios servicios;

    public Transporte() {
    }

    public Transporte(int idTransporte, String universidadSalida, String universidadLlegada, LocalDateTime horaSalida, LocalDateTime horaLlegada, float precioTransporte, Servicios servicios) {
        this.idTransporte = idTransporte;
        this.universidadSalida = universidadSalida;
        this.universidadLlegada = universidadLlegada;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.precioTransporte = precioTransporte;
        this.servicios = servicios;
    }

    public int getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    public String getUniversidadSalida() {
        return universidadSalida;
    }

    public void setUniversidadSalida(String universidadSalida) {
        this.universidadSalida = universidadSalida;
    }

    public String getUniversidadLlegada() {
        return universidadLlegada;
    }

    public void setUniversidadLlegada(String universidadLlegada) {
        this.universidadLlegada = universidadLlegada;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public LocalDateTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalDateTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public float getPrecioTransporte() {
        return precioTransporte;
    }

    public void setPrecioTransporte(float precioTransporte) {
        this.precioTransporte = precioTransporte;
    }

    public Servicios getServicios() {
        return servicios;
    }

    public void setServicios(Servicios servicios) {
        this.servicios = servicios;
    }
}
