package pe.edu.upc.vwalletweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.vwalletweb.entities.Biblioteca;

import java.util.List;

@Repository
public interface IBibliotecaRepository extends JpaRepository<Biblioteca, Integer> {

    // Query 6
    @Query(value = "SELECT b.sede_biblioteca, COUNT(l.id_libro) AS cantidad_libros\n" +
            "FROM biblioteca b\n" +
            "JOIN libro l ON b.id_biblioteca = l.biblioteca_id\n" +
            "GROUP BY b.sede_biblioteca;", nativeQuery = true)
    List<String[]>LibroDisponiblePorSede();
}
