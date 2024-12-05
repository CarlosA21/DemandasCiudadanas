package com.demandasAPI.demandasAPI.Controller;

import com.demandasAPI.demandasAPI.Model.DTO.FlujoDTO;
import com.demandasAPI.demandasAPI.Model.Flujo;
import com.demandasAPI.demandasAPI.Service.FlujoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flujo")
public class FlujoController {
    @Autowired
    private FlujoService flujoService;


    @PostMapping
    public Flujo createFlujo (@RequestBody FlujoDTO flujoDTO){
        return flujoService.createFlujo(flujoDTO);
    }

    @GetMapping
    public Iterable<Flujo> getAllFlujos(){
        return flujoService.getAllFlujos();
    }

    @GetMapping("/{id}")
    public Flujo getFlujoById(@PathVariable String id){
        return flujoService.getFlujoById(id);
    }

    @PutMapping("/{id}")
    public Flujo updateFlujo(@PathVariable String id, @RequestBody FlujoDTO flujoDTO){
        return flujoService.updateFlujo(id, flujoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteFlujo(@PathVariable String id){
        flujoService.deleteFlujo(id);
    }
}
