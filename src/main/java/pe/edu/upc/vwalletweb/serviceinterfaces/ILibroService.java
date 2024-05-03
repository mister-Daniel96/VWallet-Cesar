package pe.edu.upc.vwalletweb.serviceinterfaces;

import pe.edu.upc.vwalletweb.entities.Libro;

import java.util.List;

public interface ILibroService {
    public void insert(Libro libro);

    public List<Libro> list();

    public void delete(int idLibro);
}
