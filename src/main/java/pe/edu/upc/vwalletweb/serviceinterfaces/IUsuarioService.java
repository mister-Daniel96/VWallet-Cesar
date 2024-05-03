package pe.edu.upc.vwalletweb.serviceinterfaces;
import pe.edu.upc.vwalletweb.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public void insert(Usuario usuario);

    public List<Usuario> list();

    public void delete(Long idUsuario);

    public Usuario listarId(Long idUsuario);
}
