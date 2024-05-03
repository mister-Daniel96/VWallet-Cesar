package pe.edu.upc.vwalletweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.vwalletweb.dtos.LibroDTO;
import pe.edu.upc.vwalletweb.entities.Libro;
import pe.edu.upc.vwalletweb.serviceinterfaces.ILibroService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/libro")
public class LibroController {
    @Autowired
    private ILibroService lS;

    @PostMapping
    @PreAuthorize("hasAuthority('ESTUDIANTE') or hasAuthority('ADMIN')")
    public void registrar(@RequestBody LibroDTO libroDTO) {
        ModelMapper r = new ModelMapper();
        Libro libro = r.map(libroDTO, Libro.class);
        lS.insert(libro);
    }
    @PutMapping()
    @PreAuthorize("hasAuthority('ESTUDIANTE') or hasAuthority('ADMIN')")
    public void modificar(@RequestBody LibroDTO liDTO){
        ModelMapper m = new ModelMapper();
        Libro libro = m.map(liDTO,Libro.class);
        lS.insert(libro);
    }
    @GetMapping
    @PreAuthorize("hasAuthority('ESTUDIANTE') or hasAuthority('ADMIN')")
    public List<LibroDTO> list() {
        return lS.list().stream().map(y -> {
            ModelMapper l = new ModelMapper();
            return l.map(y, LibroDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ESTUDIANTE') or hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        lS.delete(id);
    }

}
