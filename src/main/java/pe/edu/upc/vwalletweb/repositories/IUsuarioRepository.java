package pe.edu.upc.vwalletweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.vwalletweb.entities.Usuario;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByNameUsuario(String nameUsuario);

    //BUSCAR POR NOMBRE
    @Query("select count(u.nameUsuario) from Usuario u where u.nameUsuario =:nameUsuario")
    public int buscarNameUsuario(@Param("nameUsuario") String nombre);


    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into typeUsers (typeTypeUser, usuario_id) VALUES (:typeTypeUser, :usuario_id)", nativeQuery = true)
    public void insRol(@Param("typeTypeUser") String authority, @Param("usuario_id") Long usuario_id);
}
