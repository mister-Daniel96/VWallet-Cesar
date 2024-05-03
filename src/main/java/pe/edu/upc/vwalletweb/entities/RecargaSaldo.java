package pe.edu.upc.vwalletweb.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
//Aqui se podra generar las recargas y el monto necesario a utilizar por el estudiante
@Entity
@Table(name = "recargasaldo")
public class RecargaSaldo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecargaSaldo;
    @Column(name = "montoRecarga", nullable = false)
    private float montoRecarga;
    @Column(name = "fechaRecarga", nullable = false)
    private LocalDate fechaRecarga;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public RecargaSaldo() {
    }

    public RecargaSaldo(int idRecargaSaldo, float montoRecarga, LocalDate fechaRecarga, Usuario usuario) {
        this.idRecargaSaldo = idRecargaSaldo;
        this.montoRecarga = montoRecarga;
        this.fechaRecarga = fechaRecarga;
        this.usuario = usuario;
    }

    public int getIdRecargaSaldo() {
        return idRecargaSaldo;
    }

    public void setIdRecargaSaldo(int idRecargaSaldo) {
        this.idRecargaSaldo = idRecargaSaldo;
    }

    public float getMontoRecarga() {
        return montoRecarga;
    }

    public void setMontoRecarga(float montoRecarga) {
        this.montoRecarga = montoRecarga;
    }

    public LocalDate getFechaRecarga() {
        return fechaRecarga;
    }

    public void setFechaRecarga(LocalDate fechaRecarga) {
        this.fechaRecarga = fechaRecarga;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
