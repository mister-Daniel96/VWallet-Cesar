package pe.edu.upc.vwalletweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.vwalletweb.dtos.CafeteriaDTO;
import pe.edu.upc.vwalletweb.entities.Cafeteria;
import pe.edu.upc.vwalletweb.serviceinterfaces.ICafeteriaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cafeteria")
public class CafeteriaController {
    @Autowired
    private ICafeteriaService cS;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void registrar(@RequestBody CafeteriaDTO cafeteriaDTO) {
        ModelMapper r = new ModelMapper();
        Cafeteria cafeteria = r.map(cafeteriaDTO, Cafeteria.class);
        cS.insert(cafeteria);
    }
    @PutMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody CafeteriaDTO cafeDTO){
        ModelMapper m = new ModelMapper();
        Cafeteria cafe = m.map(cafeDTO,Cafeteria.class);
        cS.insert(cafe);
    }
    @GetMapping
    @PreAuthorize("hasAuthority('ESTUDIANTE') or hasAuthority('ADMIN')")
    public List<CafeteriaDTO> list() {
        return cS.list().stream().map(y -> {
            ModelMapper l = new ModelMapper();
            return l.map(y, CafeteriaDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        cS.delete(id);
    }
}
