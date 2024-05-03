package pe.edu.upc.vwalletweb.serviceinterfaces;

import pe.edu.upc.vwalletweb.entities.TypeUser;

import java.util.List;

public interface ITypeUserService {
    public void insert(TypeUser typeUser);
    public List<TypeUser> list();
    public void delete(Long idTypeUser);
    public TypeUser listarId(Long idTypeUser);
}
