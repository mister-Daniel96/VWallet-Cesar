package pe.edu.upc.vwalletweb.dtos;

import pe.edu.upc.vwalletweb.entities.Usuario;

import java.time.LocalDate;

public class RecargaSaldoDTO {
    private int idRecargaSaldo;

    private float montoRecarga;

    private LocalDate fechaRecarga;

    private Usuario usuario;

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
