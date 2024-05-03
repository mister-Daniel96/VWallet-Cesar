package pe.edu.upc.vwalletweb.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.vwalletweb.entities.Servicios;
import pe.edu.upc.vwalletweb.repositories.IServiciosRepository;
import pe.edu.upc.vwalletweb.serviceinterfaces.IServiciosService;

import java.util.List;

@Service
public class ServiciosServiceImplement implements IServiciosService {
    @Autowired
    private IServiciosRepository sR;

    @Override
    public void insert(Servicios servicios) {
        sR.save(servicios);
    }

    @Override
    public List<Servicios> list() {
        return sR.findAll();
    }

    @Override
    public void delete(int idServicio) {
        sR.deleteById(idServicio);
    }

    @Override
    public List<Servicios> buscarEstado(String estados) {
        return sR.buscarEstado(estados);
    }
}
