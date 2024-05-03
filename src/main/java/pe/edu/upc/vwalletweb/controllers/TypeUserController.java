package pe.edu.upc.vwalletweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.vwalletweb.dtos.TypeUserDTO;
import pe.edu.upc.vwalletweb.entities.TypeUser;
import pe.edu.upc.vwalletweb.serviceinterfaces.ITypeUserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/typeUsers")
public class TypeUserController {
    @Autowired
    private ITypeUserService tS;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void registrar(@RequestBody TypeUserDTO dto) {
        ModelMapper m = new ModelMapper();
        TypeUser r = m.map(dto, TypeUser.class);
        tS.insert(r);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody TypeUserDTO dto) {
        ModelMapper m = new ModelMapper();
        TypeUser r = m.map(dto, TypeUser.class);
        tS.insert(r);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Long id) {
        tS.delete(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public TypeUserDTO listarId(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        TypeUserDTO dto = m.map(tS.listarId(id), TypeUserDTO.class);
        return dto;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<TypeUserDTO> listar() {
        return tS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TypeUserDTO.class);
        }).collect(Collectors.toList());
    }
}
