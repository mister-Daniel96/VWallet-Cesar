package pe.edu.upc.vwalletweb.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.vwalletweb.entities.Cafeteria;
import pe.edu.upc.vwalletweb.repositories.ICafeteriaRepository;
import pe.edu.upc.vwalletweb.serviceinterfaces.ICafeteriaService;

import java.util.List;

@Service
public class CafeteriaServiceImplement implements ICafeteriaService {
    @Autowired
    private ICafeteriaRepository cR;
    @Override
    public void insert(Cafeteria cafeteria) {
        cR.save(cafeteria);
    }

    @Override
    public List<Cafeteria> list() {
        return cR.findAll();
    }

    @Override
    public void delete(int idCafeteria) {
        cR.deleteById(idCafeteria);
    }
}
