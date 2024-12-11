package com.demandasAPI.demandasAPI.Controller;


import com.demandasAPI.demandasAPI.Model.DTO.TransicionDTO;
import com.demandasAPI.demandasAPI.Model.Transicion;
import com.demandasAPI.demandasAPI.Service.TransicionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transicion")
public class TransicionController {

    @Autowired
    private TransicionService transicionService;


    @PostMapping
    public Transicion createTransicion (@RequestBody TransicionDTO transicionDTO){
        return transicionService.createTransicion(transicionDTO);
    }
    @GetMapping
    public List<Transicion> getAllTransiciones(){
        return transicionService.getAllTransiciones();
    }
    @GetMapping("/{id}")
    public Transicion getTransicionById(@PathVariable String id){
        return transicionService.getTransicionById(id);
    }
    @PutMapping("/{id}")
    public Transicion updateTransicion(@PathVariable String id, @RequestBody TransicionDTO transicionDTO){
        return transicionService.updateTransicion(id, transicionDTO);
    }
    @DeleteMapping
    public void deleteTransicion(@PathVariable String id){
        transicionService.deleteTransicion(id);
    }
}
