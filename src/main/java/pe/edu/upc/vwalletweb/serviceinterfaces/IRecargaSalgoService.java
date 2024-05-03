package pe.edu.upc.vwalletweb.serviceinterfaces;

import pe.edu.upc.vwalletweb.entities.RecargaSaldo;

import java.time.LocalDate;
import java.util.List;

public interface IRecargaSalgoService {
    void insert(RecargaSaldo recargasaldo);

    List<RecargaSaldo> list();

    void delete(int idRecargaSaldo);

    List<String[]> TotalRecargadoUsuario();

    List<String[]> FechaRecargaSaldoIntervalo(LocalDate fInicio, LocalDate fFin);

}
