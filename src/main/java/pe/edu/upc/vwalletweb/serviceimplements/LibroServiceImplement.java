package pe.edu.upc.vwalletweb.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.vwalletweb.entities.Libro;
import pe.edu.upc.vwalletweb.repositories.ILibroRepository;
import pe.edu.upc.vwalletweb.serviceinterfaces.ILibroService;

import java.util.List;

@Service
public class LibroServiceImplement implements ILibroService {
    @Autowired
    private ILibroRepository lR;
    @Override
    public void insert(Libro libro) {
        lR.save(libro);
    }

    @Override
    public List<Libro> list() {
        return lR.findAll();
    }

    @Override
    public void delete(int idLibro) {
        lR.deleteById(idLibro);
    }
}
