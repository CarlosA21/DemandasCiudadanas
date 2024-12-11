package com.demandasAPI.demandasAPI.Service;


import com.demandasAPI.demandasAPI.Model.DTO.SubtipologiaDTO;
import com.demandasAPI.demandasAPI.Model.Subtipologia;
import com.demandasAPI.demandasAPI.Repository.SubtipologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubtipologiaService {

    @Autowired
    private SubtipologiaRepository subtipologiaRepository;


    public Subtipologia  createSubtipologia(SubtipologiaDTO subtipologiaDTO){
        Subtipologia subtipologia = Subtipologia.builder()
                .SiguienteSubTip(subtipologiaDTO.getSiguienteSubTip())
                .build();

        return subtipologiaRepository.save(subtipologia);
    }

    public List<Subtipologia> getAllSubtipologias(){
        return subtipologiaRepository.findAll();
    }
    public Subtipologia getSubtipologiaById(String id){
        return subtipologiaRepository.findById(id).orElse(null);
    }

    public Subtipologia updateSubtipologia(String id, SubtipologiaDTO subtipologiaDTO){
        return subtipologiaRepository.findById(id).map(subtipologia -> {
            subtipologia.setSiguienteSubTip(subtipologiaDTO.getSiguienteSubTip());
            return subtipologiaRepository.save(subtipologia);
        }).orElse(null);
    }
    public void deleteSubtipologia(String id){
        subtipologiaRepository.deleteById(id);
    }
}
