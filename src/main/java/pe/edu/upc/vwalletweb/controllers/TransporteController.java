package pe.edu.upc.vwalletweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.vwalletweb.dtos.TotalGastoxUsuarioDTO;
import pe.edu.upc.vwalletweb.dtos.TransporteDTO;
import pe.edu.upc.vwalletweb.dtos.TransportesUniversidadesDTO;
import pe.edu.upc.vwalletweb.entities.Transporte;
import pe.edu.upc.vwalletweb.serviceinterfaces.ITransporteService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transporte")
public class TransporteController {
    @Autowired
    private ITransporteService tS;

    @PostMapping
    @PreAuthorize("hasAuthority('ESTUDIANTE') or hasAuthority('ADMIN')")
    public void registrar(@RequestBody TransporteDTO transporteDTO) {
        ModelMapper r = new ModelMapper();
        Transporte transporte = r.map(transporteDTO, Transporte.class);
        tS.insert(transporte);
    }

    @PutMapping()
    @PreAuthorize("hasAuthority('ESTUDIANTE') or hasAuthority('ADMIN')")
    public void modificar(@RequestBody TransporteDTO transportDTO) {
        ModelMapper m = new ModelMapper();
        Transporte transport = m.map(transportDTO, Transporte.class);
        tS.insert(transport);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ESTUDIANTE') or hasAuthority('ADMIN')")
    public List<TransporteDTO> list() {
        return tS.list().stream().map(y -> {
            ModelMapper l = new ModelMapper();
            return l.map(y, TransporteDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ESTUDIANTE') or hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id) {
        tS.delete(id);
    }

    @GetMapping("/{u_salida}/{u_llegada}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<TransportesUniversidadesDTO> transportesUniversidades(
            @PathVariable("u_salida") String uSalida,
            @PathVariable("u_llegada") String uLlegada
    ) {
        List<String[]> transportesDeLaLista = tS.transportesUniversidades(uSalida, uLlegada);
        List<TransportesUniversidadesDTO> dtoLista = new ArrayList<>();
        for (String[] columna : transportesDeLaLista) {
            TransportesUniversidadesDTO dto = new TransportesUniversidadesDTO();
            dto.setIdTransporte(Integer.parseInt(columna[0]));
            dto.setUniversidadSalida(columna[1]);
            dto.setUniversidadLlegada(columna[2]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }
    @GetMapping("/totalgastoxusuario")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<TotalGastoxUsuarioDTO> TotalGastoPorUsuario(){
        List<String[]> filalistatotalgasto = tS.totalGastoxUsuario();
        List<TotalGastoxUsuarioDTO> dtoLista = new ArrayList<>();
        for(String[] columna:filalistatotalgasto){
            TotalGastoxUsuarioDTO dto = new TotalGastoxUsuarioDTO();
            dto.setUsuarioId(Integer.parseInt(columna[0]));
            dto.setTotalGasto(Float.parseFloat(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
