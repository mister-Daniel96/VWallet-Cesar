package pe.edu.upc.vwalletweb.serviceinterfaces;

import pe.edu.upc.vwalletweb.entities.Biblioteca;

import java.util.List;

public interface IBibliotecaService {
    public void insert(Biblioteca biblioteca);

    public List<Biblioteca> list();

    public void delete(int idBiblioteca);

    List<String[]>LibroDisponiblePorSede();
}
