package pe.edu.upc.vwalletweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.vwalletweb.dtos.DetalleReservasDTO;
import pe.edu.upc.vwalletweb.dtos.TotalGastoxUsuarioDTO;
import pe.edu.upc.vwalletweb.dtos.totalViajesRealizadosPorTransporteidDTO;
import pe.edu.upc.vwalletweb.entities.DetalleReservas;
import pe.edu.upc.vwalletweb.serviceinterfaces.IDetalleReservasService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/detallereservas")
public class DetalleReservasController {
    @Autowired
    private IDetalleReservasService drS;

    @PostMapping
    @PreAuthorize("hasAuthority('ESTUDIANTE') or hasAuthority('ADMIN')")
    public void registrar(@RequestBody DetalleReservasDTO dreservasDTO) {
        ModelMapper r = new ModelMapper();
        DetalleReservas detallereservas = r.map(dreservasDTO, DetalleReservas.class);
        drS.insert(detallereservas );
    }
    @PutMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody DetalleReservasDTO dereservasDTO){
        ModelMapper m = new ModelMapper();
        DetalleReservas dereserva = m.map(dereservasDTO,DetalleReservas.class);
        drS.insert(dereserva);
    }
    @GetMapping
    @PreAuthorize("hasAuthority('ESTUDIANTE') or hasAuthority('ADMIN')")
    public List<DetalleReservasDTO> list() {
        return drS.list().stream().map(y -> {
            ModelMapper l = new ModelMapper();
            return l.map(y, DetalleReservasDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        drS.delete(id);
    }

    @GetMapping("/viajesmasrealizados")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<totalViajesRealizadosPorTransporteidDTO> Obtenerviajesmasrealizados(){
        List<String[]> filalistaviajesmasrealizados = drS.totalViajesRealizadosPorTransporteID();
        List<totalViajesRealizadosPorTransporteidDTO> dtoLista = new ArrayList<>();
        for(String[] columna:filalistaviajesmasrealizados){
            totalViajesRealizadosPorTransporteidDTO dto = new totalViajesRealizadosPorTransporteidDTO();
            dto.setIdTransporte(Integer.parseInt(columna[0]));
            dto.setUniversidadSalida(columna[1]);
            dto.setUniversidadLlegada(columna[2]);
            dto.setTotalNumViajes(Integer.parseInt(columna[3]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
