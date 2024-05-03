package pe.edu.upc.vwalletweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.vwalletweb.entities.DetalleReservas;

import java.util.List;

@Repository
public interface IDetalleReservasRepository extends JpaRepository<DetalleReservas,Integer> {
    @Query(value = "SELECT t.id_transporte, t.universidad_salida, t.universidad_llegada, COUNT(*) AS num_viajes\n " +
            "FROM detallereservas dr\n " +
            "JOIN transporte t ON dr.transporte_id = t.id_transporte\n " +
            "GROUP BY t.id_transporte, t.universidad_salida, t.universidad_llegada ", nativeQuery = true)
    List<String[]> totalViajesRealizadosPorTransporteID();
}
