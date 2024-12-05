package com.demandasAPI.demandasAPI.Controller;


import com.demandasAPI.demandasAPI.Model.DTO.DemandaDTO;
import com.demandasAPI.demandasAPI.Model.Demanda;
import com.demandasAPI.demandasAPI.Service.DemandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/demanda")
public class DemandaController {

    @Autowired
    private DemandaService demandaService;

    @PostMapping
    public Demanda createDemanda(@RequestBody DemandaDTO demandaDTO){
        return demandaService.createDemanda(demandaDTO);
    }
    @GetMapping
    public Iterable<Demanda> getAllDemandas(){
        return demandaService.getAllDemandas();
    }
    @GetMapping("/{id}")
    public Demanda getDemandaById(@PathVariable String id){
        return demandaService.getDemandaById(id);
    }
    @PutMapping("/{id}")
    public Demanda updateDemanda(@PathVariable String id, @RequestBody DemandaDTO demandaDTO){
        return demandaService.updateDemanda(id, demandaDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDemanda(@PathVariable String id){
        demandaService.deleteDemanda(id);
    }
}
