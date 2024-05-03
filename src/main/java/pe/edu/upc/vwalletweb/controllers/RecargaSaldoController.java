package pe.edu.upc.vwalletweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.vwalletweb.dtos.FechaRecargaSaldoIntervaloDTO;
import pe.edu.upc.vwalletweb.dtos.RecargaSaldoDTO;
import pe.edu.upc.vwalletweb.dtos.TotalRecargadoUsuarioDTO;
import pe.edu.upc.vwalletweb.entities.RecargaSaldo;
import pe.edu.upc.vwalletweb.serviceinterfaces.IRecargaSalgoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recargasaldo")
public class RecargaSaldoController {
    @Autowired
    private IRecargaSalgoService rsS;

    @PostMapping
    @PreAuthorize("hasAuthority('PADRE') or hasAuthority('ADMIN')")
    public void registrar(@RequestBody RecargaSaldoDTO recargasaldoDTO) {
        ModelMapper r = new ModelMapper();
        RecargaSaldo recargasaldo = r.map(recargasaldoDTO, RecargaSaldo.class);
        rsS.insert(recargasaldo);
    }

    @PutMapping()
    @PreAuthorize("hasAuthority('PADRE') or hasAuthority('ADMIN')")
    public void modificar(@RequestBody RecargaSaldoDTO recargasalDTO) {
        ModelMapper m = new ModelMapper();
        RecargaSaldo recargasal = m.map(recargasalDTO, RecargaSaldo.class);
        rsS.insert(recargasal);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('PADRE') or hasAuthority('ADMIN')")
    public List<RecargaSaldoDTO> list() {
        return rsS.list().stream().map(y -> {
            ModelMapper l = new ModelMapper();
            return l.map(y, RecargaSaldoDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('PADRE') or hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id) {
        rsS.delete(id);
    }

    @GetMapping("/totalrecargado")
    @PreAuthorize("hasAuthority('PADRE') or hasAuthority('ADMIN')")
    public List<TotalRecargadoUsuarioDTO> TotalRecargado() {
        List<String[]> filalistarecargatotal = rsS.TotalRecargadoUsuario();
        List<TotalRecargadoUsuarioDTO> dtoLista = new ArrayList<>();
        for (String[] columna : filalistarecargatotal) {
            TotalRecargadoUsuarioDTO dto = new TotalRecargadoUsuarioDTO();
            dto.setIdUsuario(Integer.parseInt(columna[0]));
            dto.setTotal_recargado(Float.parseFloat(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }


    @GetMapping("/{fInicio}/{fFin}")
    @PreAuthorize("hasAuthority('PADRE') or hasAuthority('ADMIN')")
    public List<FechaRecargaSaldoIntervaloDTO> FechaRecarga(
            @PathVariable("fInicio") LocalDate fInicio,
            @PathVariable("fFin") LocalDate fFin
    ) {
        List<String[]> filalistafecharecarga = rsS.FechaRecargaSaldoIntervalo(fInicio, fFin);
        List<FechaRecargaSaldoIntervaloDTO> dtoLista = new ArrayList<>();
        for (String[] columna : filalistafecharecarga) {
            FechaRecargaSaldoIntervaloDTO dto = new FechaRecargaSaldoIntervaloDTO();
            dto.setIdRecargaSaldo(Integer.parseInt(columna[0]));
            dto.setFechaRecarga(LocalDate.parse(columna[1]));
            dto.setMontorecarga(Float.parseFloat(columna[2]));
            dto.setIdUsuario(Integer.parseInt(columna[3]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }


}
