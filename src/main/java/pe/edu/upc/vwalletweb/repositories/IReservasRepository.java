package pe.edu.upc.vwalletweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.vwalletweb.entities.Reservas;

@Repository
public interface IReservasRepository extends JpaRepository<Reservas,Integer> {
}
