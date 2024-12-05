package com.demandasAPI.demandasAPI.Controller;

import com.demandasAPI.demandasAPI.Model.DTO.EstadoDTO;
import com.demandasAPI.demandasAPI.Model.Estado;
import com.demandasAPI.demandasAPI.Service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @PostMapping
    public Estado createUsuario(@RequestBody EstadoDTO estadoDTO){
        return estadoService.createEstado(estadoDTO);
    }

    @GetMapping
    public Iterable<Estado> getAllEstados(){
        return estadoService.getAllEstados();
    }

    @GetMapping("/{id}")
    public Estado getEstadoById(@PathVariable String id){
        return estadoService.getEstadoById(id);
    }

    @PutMapping("/{id}")
    public Estado updateEstado(@PathVariable String id, @RequestBody EstadoDTO estadoDTO){
        return estadoService.updateEstado(id, estadoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteEstado(@PathVariable String id){
        estadoService.deleteEstado(id);
    }
}
