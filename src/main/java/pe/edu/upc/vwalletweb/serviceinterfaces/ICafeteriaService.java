package pe.edu.upc.vwalletweb.serviceinterfaces;

import pe.edu.upc.vwalletweb.entities.Cafeteria;

import java.util.List;

public interface ICafeteriaService {
    public void insert(Cafeteria cafeteria);

    public List<Cafeteria> list();

    public void delete(int idCafeteria);
}
