package pe.edu.upc.vwalletweb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "detallereservas")
public class DetalleReservas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleReserva;
    @ManyToOne
    @JoinColumn(name = "reservas_id")
    private Reservas reservas;
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
    @ManyToOne
    @JoinColumn(name = "transporte_id")
    private Transporte transporte;
    @ManyToOne
    @JoinColumn(name = "libro_id")
    private Libro libro;



    public DetalleReservas() {
    }

    public DetalleReservas(int idDetalleReserva, Reservas reservas, Menu menu, Transporte transporte, Libro libro) {
        this.idDetalleReserva = idDetalleReserva;
        this.reservas = reservas;
        this.menu = menu;
        this.transporte = transporte;
        this.libro = libro;
    }

    public int getIdDetalleReserva() {
        return idDetalleReserva;
    }

    public void setIdDetalleReserva(int idDetalleReserva) {
        this.idDetalleReserva = idDetalleReserva;
    }

    public Reservas getReservas() {
        return reservas;
    }

    public void setReservas(Reservas reservas) {
        this.reservas = reservas;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
}
