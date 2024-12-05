package com.demandasAPI.demandasAPI.Service;


import com.demandasAPI.demandasAPI.Model.DTO.FlujoDTO;
import com.demandasAPI.demandasAPI.Model.Flujo;
import com.demandasAPI.demandasAPI.Repository.FlujoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlujoService {

    @Autowired
    private FlujoRepository flujoRepository;


    public Flujo createFlujo(FlujoDTO flujoDTO){
        Flujo flujo = Flujo.builder()
                .nombre(flujoDTO.getNombre())
                .Descripcion(flujoDTO.getDescripcion())
                .Area(flujoDTO.getArea())
                .actividades(flujoDTO.getActividades())
                .build();
        return flujoRepository.save(flujo);
    }
    
    public List<Flujo> getAllFlujos(){
        return flujoRepository.findAll();
    }
    public Flujo getFlujoById(String id){
        return flujoRepository.findById(id).orElse(null);
    }
    

    public Flujo updateFlujo(String id, FlujoDTO flujoDTO) {
        return flujoRepository.findById(id)
                .map(flujo -> {
                    flujo.setNombre(flujoDTO.getNombre());
                    flujo.setDescripcion(flujoDTO.getDescripcion());
                    flujo.setArea(flujoDTO.getArea());
                    flujo.setActividades(flujoDTO.getActividades());
                    return flujoRepository.save(flujo);
                })
                .orElse(null);
    }

    public void deleteFlujo(String id){
        flujoRepository.deleteById(id);
    }
}
