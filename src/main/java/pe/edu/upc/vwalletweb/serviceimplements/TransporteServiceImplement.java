package pe.edu.upc.vwalletweb.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.vwalletweb.entities.Transporte;
import pe.edu.upc.vwalletweb.repositories.ITransporteRepository;
import pe.edu.upc.vwalletweb.serviceinterfaces.ITransporteService;

import java.util.List;

@Service
public class TransporteServiceImplement implements ITransporteService {
    @Autowired
    private ITransporteRepository tR;

    @Override
    public void insert(Transporte transporte) {
        tR.save(transporte);
    }

    @Override
    public List<Transporte> list() {
        return tR.findAll();
    }

    @Override
    public void delete(int idTransporte) {
        tR.deleteById(idTransporte);
    }

    @Override
    public List<String[]> transportesUniversidades(String uSalida, String uLlegada) {
        return tR.transportesUniversidades(uSalida, uLlegada);
    }

    @Override
    public List<String[]> totalGastoxUsuario() {
        return tR.totalGastoxUsuario();
    }
}
