package pe.edu.upc.vwalletweb.serviceinterfaces;

import pe.edu.upc.vwalletweb.entities.Servicios;

import java.util.List;

public interface IServiciosService {
    public void insert(Servicios servicios);

    public List<Servicios> list();

    public void delete(int idServicio);

    List<Servicios> buscarEstado( String estados);


}
