package pe.edu.upc.vwalletweb.serviceinterfaces;

import pe.edu.upc.vwalletweb.entities.Transporte;

import java.util.List;

public interface ITransporteService {
    void insert(Transporte transporte);

    List<Transporte> list();

    void delete(int idTransporte);

    List<String[]> transportesUniversidades(String uSalida, String uLlegada);
    List<String[]> totalGastoxUsuario();
}
