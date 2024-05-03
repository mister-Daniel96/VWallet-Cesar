package pe.edu.upc.vwalletweb.serviceinterfaces;

import pe.edu.upc.vwalletweb.entities.Reservas;
import pe.edu.upc.vwalletweb.entities.Servicios;

import java.util.List;

public interface IReservasService {

    public void insert(Reservas reservas);

    public List<Reservas> list();

    public void delete(int idReservas);
}
