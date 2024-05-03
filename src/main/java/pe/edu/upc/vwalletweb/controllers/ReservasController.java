package pe.edu.upc.vwalletweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.vwalletweb.dtos.ReservasDTO;
import pe.edu.upc.vwalletweb.dtos.ServiciosDTO;
import pe.edu.upc.vwalletweb.entities.Reservas;
import pe.edu.upc.vwalletweb.entities.Servicios;
import pe.edu.upc.vwalletweb.serviceinterfaces.IReservasService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservas")
public class ReservasController {
    @Autowired
    private IReservasService rS;

    @PostMapping
    @PreAuthorize("hasAuthority('ESTUDIANTE') or hasAuthority('ADMIN')")
    public void registrar(@RequestBody ReservasDTO reservasDTO) {
        ModelMapper r = new ModelMapper();
        Reservas reservas = r.map(reservasDTO, Reservas.class);
        rS.insert(reservas);
    }
    @PutMapping()
    @PreAuthorize("hasAuthority('ESTUDIANTE') or hasAuthority('ADMIN')")
    public void modificar(@RequestBody ReservasDTO reserDTO){
        ModelMapper m = new ModelMapper();
        Reservas reser = m.map(reserDTO,Reservas.class);
        rS.insert(reser);
    }
    @GetMapping
    @PreAuthorize("hasAuthority('ESTUDIANTE') or hasAuthority('ADMIN')")
    public List<ReservasDTO> list() {
        return rS.list().stream().map(y -> {
            ModelMapper l = new ModelMapper();
            return l.map(y, ReservasDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ESTUDIANTE') or hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        rS.delete(id);
    }
}
