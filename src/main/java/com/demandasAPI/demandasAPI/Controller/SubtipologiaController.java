package com.demandasAPI.demandasAPI.Controller;


import com.demandasAPI.demandasAPI.Model.DTO.SubtipologiaDTO;
import com.demandasAPI.demandasAPI.Model.Subtipologia;
import com.demandasAPI.demandasAPI.Service.SubtipologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subtipologia")
public class SubtipologiaController {
    @Autowired
    private SubtipologiaService subtipologiaService;


    @PostMapping
    public Subtipologia createSubtipologia(@RequestBody SubtipologiaDTO subtipologiaDTO){
        return subtipologiaService.createSubtipologia(subtipologiaDTO);
    }
    @GetMapping
    public Iterable<Subtipologia> getAllSubtipologias(){
        return subtipologiaService.getAllSubtipologias();
    }
    @GetMapping("/{id}")
    public Subtipologia getSubtipologiaById(@PathVariable String id){
        return subtipologiaService.getSubtipologiaById(id);
    }
    @PutMapping("/{id}")
    public Subtipologia updateSubtipologia(@PathVariable String id, @RequestBody SubtipologiaDTO subtipologiaDTO){
        return subtipologiaService.updateSubtipologia(id, subtipologiaDTO);
    }

    @DeleteMapping
    public void deleteSubtipologia(@PathVariable String id){
        subtipologiaService.deleteSubtipologia(id);
    }
}
