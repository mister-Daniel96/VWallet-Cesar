package pe.edu.upc.vwalletweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.vwalletweb.dtos.ServiciosDTO;
import pe.edu.upc.vwalletweb.entities.Servicios;
import pe.edu.upc.vwalletweb.serviceinterfaces.IServiciosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/servicios")
public class ServiciosController {
    @Autowired
    private IServiciosService sS;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void registrar(@RequestBody ServiciosDTO serviciosDTO) {
        ModelMapper r = new ModelMapper();
        Servicios servicios = r.map(serviciosDTO, Servicios.class);
        sS.insert(servicios);
    }
    @PutMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody ServiciosDTO serviDTO){
        ModelMapper m = new ModelMapper();
        Servicios servi = m.map(serviDTO,Servicios.class);
        sS.insert(servi);
    }
    @GetMapping
    @PreAuthorize("hasAuthority('ESTUDIANTE') or hasAuthority('ADMIN')")
    public List<ServiciosDTO> list() {
        return sS.list().stream().map(y -> {
            ModelMapper l = new ModelMapper();
            return l.map(y, ServiciosDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        sS.delete(id);
    }

    @GetMapping("/buscarestado")
    @PreAuthorize("hasAuthority('ESTUDIANTE') or hasAuthority('ADMIN')")
    public List<ServiciosDTO> buscar(@RequestParam String est) {
        return sS.buscarEstado(est).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ServiciosDTO.class);
        }).collect(Collectors.toList());
    }


}
