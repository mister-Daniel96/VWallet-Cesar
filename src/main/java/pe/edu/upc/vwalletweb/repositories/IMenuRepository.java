package pe.edu.upc.vwalletweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.vwalletweb.entities.Menu;

import java.util.List;

@Repository
public interface IMenuRepository extends JpaRepository<Menu, Integer> {

    //Query 4
    @Query(value = "SELECT m.* FROM menu m \n" +
            "JOIN cafeteria c ON m.cafeteria_id = c.id_cafeteria \n" +
            "WHERE c.sede_cafeteria = 'Villa'", nativeQuery = true)
    List<String[]> MenuDisponiblePorSede();
    //Query 2
    @Query(value = "SELECT dr.menu_id, SUM(m.precio_menu) AS total_gasto \n" +
            "FROM detallereservas dr \n" +
            "         JOIN menu m ON dr.menu_id = m.id_menu \n" +
            "GROUP BY dr.menu_id \n" +
            "ORDER BY total_gasto DESC \n" +
            "LIMIT 3; \n", nativeQuery = true)
    List<String[]> menusCaros();
//Query 8
    @Query(value = "SELECT m.plato_principal AS plato_mas_pedido, COUNT(*) AS cantidad \n" +
            "FROM Menu m \n" +
            " JOIN DetalleReservas dr ON dr.menu_id = m.id_menu \n" +
            " GROUP BY m.plato_principal \n" +
            "ORDER BY cantidad DESC", nativeQuery = true)
    List<String[]>platosMasPedidos();
//Query 10
    @Query(value = "SELECT m.id_menu, m.precio_menu " +
    "FROM menu m " +
    "WHERE m.precio_menu < (SELECT AVG(precio_menu) FROM menu);",nativeQuery = true)
    List<String[]>menusEconomicos();
}
