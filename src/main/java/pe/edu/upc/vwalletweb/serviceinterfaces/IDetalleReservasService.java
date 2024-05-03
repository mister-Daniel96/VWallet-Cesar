package pe.edu.upc.vwalletweb.serviceinterfaces;


import pe.edu.upc.vwalletweb.entities.DetalleReservas;

import java.util.List;

public interface IDetalleReservasService {
    public void insert(DetalleReservas detallereservas);

    public List<DetalleReservas> list();

    public void delete(int idDetalleReserva);
    List<String[]> totalViajesRealizadosPorTransporteID();
}
