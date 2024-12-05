package com.demandasAPI.demandasAPI.Controller;


import com.demandasAPI.demandasAPI.Model.DTO.ExpedienteDTO;
import com.demandasAPI.demandasAPI.Model.Expediente;
import com.demandasAPI.demandasAPI.Service.ExpedienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expedientes")
public class ExpedienteController {

    @Autowired
    private ExpedienteService expedienteService;

    @PostMapping
    public Expediente createExpediente(@RequestBody ExpedienteDTO expedienteDTO) {
        return expedienteService.createExpediente(expedienteDTO);
    }

    @GetMapping
    public List<Expediente> getAllExpedientes() {
        return expedienteService.getAllExpedientes();
    }

    @GetMapping("/{id}")
    public Expediente getExpedienteById(@PathVariable String id) {
        return expedienteService.getExpedienteById(id);
    }

    @PutMapping("/{id}")
    public Expediente updateExpediente(@PathVariable String id, @RequestBody ExpedienteDTO expedienteDTO) {
        return expedienteService.updateExpediente(id, expedienteDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteExpediente(@PathVariable String id) {
        expedienteService.deleteExpediente(id);
    }

}
