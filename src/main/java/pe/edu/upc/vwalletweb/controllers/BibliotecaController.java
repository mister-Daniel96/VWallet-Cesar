package pe.edu.upc.vwalletweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.vwalletweb.dtos.BibliotecaDTO;
import pe.edu.upc.vwalletweb.dtos.LibroDisponiblePorSedeDTO;
import pe.edu.upc.vwalletweb.entities.Biblioteca;
import pe.edu.upc.vwalletweb.serviceinterfaces.IBibliotecaService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/biblioteca")
public class BibliotecaController {
    @Autowired
    private IBibliotecaService bS;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void registrar(@RequestBody BibliotecaDTO bibliotecaDTO) {
        ModelMapper r = new ModelMapper();
        Biblioteca biblioteca = r.map(bibliotecaDTO, Biblioteca.class);
        bS.insert(biblioteca);
    }

    @PutMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody BibliotecaDTO bibliotecDTO) {
        ModelMapper m = new ModelMapper();
        Biblioteca bibliotec = m.map(bibliotecDTO, Biblioteca.class);
        bS.insert(bibliotec);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ESTUDIANTE') or hasAuthority('ADMIN')")
    public List<BibliotecaDTO> list() {
        return bS.list().stream().map(y -> {
            ModelMapper l = new ModelMapper();
            return l.map(y, BibliotecaDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id) {
        bS.delete(id);
    }
    
    @GetMapping("/librodisponibleporsede")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<LibroDisponiblePorSedeDTO> librodisponibleporsede() {
        List<String[]> librosdispos = bS.LibroDisponiblePorSede();
        List<LibroDisponiblePorSedeDTO> dtoLista = new ArrayList<>();
        for (String[] columna : librosdispos) {
            LibroDisponiblePorSedeDTO dto = new LibroDisponiblePorSedeDTO();
            dto.setSedeBiblioteca(columna[0]);
            dto.setCantidad_libros(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
