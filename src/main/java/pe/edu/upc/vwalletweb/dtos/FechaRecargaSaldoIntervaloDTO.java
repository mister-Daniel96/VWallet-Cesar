package pe.edu.upc.vwalletweb.dtos;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class FechaRecargaSaldoIntervaloDTO {
private int idRecargaSaldo;
private LocalDate fechaRecarga;

private float montorecarga;

private int idUsuario;

    public int getIdRecargaSaldo() {
        return idRecargaSaldo;
    }

    public void setIdRecargaSaldo(int idRecargaSaldo) {
        this.idRecargaSaldo = idRecargaSaldo;
    }

    public LocalDate getFechaRecarga() {
        return fechaRecarga;
    }

    public void setFechaRecarga(LocalDate fechaRecarga) {
        this.fechaRecarga = fechaRecarga;
    }

    public float getMontorecarga() {
        return montorecarga;
    }

    public void setMontorecarga(float montorecarga) {
        this.montorecarga = montorecarga;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
