package com.demandasAPI.demandasAPI.Controller;


import com.demandasAPI.demandasAPI.Model.DTO.TipologiaDTO;
import com.demandasAPI.demandasAPI.Model.Tipologia;
import com.demandasAPI.demandasAPI.Service.TipologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipologia")
public class TipologiaController {
    @Autowired
    private TipologiaService tipologiaService;


    @PostMapping
    public Tipologia createTipologia (@RequestBody TipologiaDTO tipologiaDTO){
        return tipologiaService.createTipologia(tipologiaDTO);
    }

    @GetMapping
    public List<Tipologia> getAllTipologias(){
        return tipologiaService.getAllTipologias();
    }

    @GetMapping("/{id}")
    public Tipologia getTipologiaById(@PathVariable String id){
        return tipologiaService.getTipologiaById(id);
    }

    @PutMapping("/{id}")
    public Tipologia updateTipologia(@PathVariable String id, @RequestBody TipologiaDTO tipologiaDTO){
        return tipologiaService.updateTipologia(id, tipologiaDTO);
    }

    @DeleteMapping
    public void deleteTipologia(@PathVariable String id){
        tipologiaService.deleteTipologia(id);
    }
}
