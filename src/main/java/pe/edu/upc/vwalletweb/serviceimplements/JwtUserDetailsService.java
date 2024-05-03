package pe.edu.upc.vwalletweb.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upc.vwalletweb.entities.Usuario;
import pe.edu.upc.vwalletweb.repositories.IUsuarioRepository;

import java.util.ArrayList;
import java.util.List;

//Clase 2
@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private IUsuarioRepository repo;

    /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Aqui lógica para buscar el usuario en BD
        //Usuario defecto web:password

        if ("web".equals(username)) {
            return new User("web", "$2a$12$CTtjF8P3IJVK6pP4w9pTxuldMqQRrfrLbLLIlasdu2K6ii2vWGly2",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
    }*/
    @Override
    public UserDetails loadUserByUsername(String nameUsuario) throws UsernameNotFoundException {
        Usuario usuario = repo.findByNameUsuario(nameUsuario);

        if(usuario == null) {
            throw new UsernameNotFoundException(String.format("User not exists", nameUsuario));
        }

        List<GrantedAuthority> typeUsers = new ArrayList<>();

        usuario.getTypeUsers().forEach(rol -> {
            typeUsers.add(new SimpleGrantedAuthority(rol.getTypeTypeUser()));
        });
        //Solo si es enabled:true--> es considerado valido y nos genera el token en otro caso no
        UserDetails ud = new org.springframework.security.core.userdetails.User(usuario.getNameUsuario(), usuario.getPasswordUsuario(), usuario.getEnabledUsuario(), true, true, true, typeUsers);

        return ud;
    }
}
