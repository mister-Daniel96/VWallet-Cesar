package pe.edu.upc.vwalletweb.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.vwalletweb.entities.Biblioteca;
import pe.edu.upc.vwalletweb.repositories.IBibliotecaRepository;
import pe.edu.upc.vwalletweb.serviceinterfaces.IBibliotecaService;

import java.util.List;

@Service
public class BibliotecaServiceImplement implements IBibliotecaService {
    @Autowired
    private IBibliotecaRepository bR;
    @Override
    public void insert(Biblioteca biblioteca) {
        bR.save(biblioteca);
    }

    @Override
    public List<Biblioteca> list() {
        return bR.findAll();
    }

    @Override
    public void delete(int idBiblioteca) {
        bR.deleteById(idBiblioteca);
    }

    @Override
    public List<String[]> LibroDisponiblePorSede() {
        return bR.LibroDisponiblePorSede();
    }
}
