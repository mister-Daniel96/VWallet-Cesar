package pe.edu.upc.vwalletweb.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.vwalletweb.entities.TypeUser;
import pe.edu.upc.vwalletweb.repositories.ITypeUserRepository;
import pe.edu.upc.vwalletweb.serviceinterfaces.ITypeUserService;

import java.util.List;

@Service
public class TypeUserServiceImplement implements ITypeUserService {
    @Autowired
    private ITypeUserRepository tR;

    @Override
    public void insert(TypeUser typeUser) {
        tR.save(typeUser);
    }

    @Override
    public List<TypeUser> list() {
        return tR.findAll();
    }

    @Override
    public void delete(Long idTypeUser) {
        tR.deleteById(idTypeUser);
    }

    @Override
    public TypeUser listarId(Long idTypeUser) {
        return tR.findById(idTypeUser).orElse(new TypeUser());
    }
}

