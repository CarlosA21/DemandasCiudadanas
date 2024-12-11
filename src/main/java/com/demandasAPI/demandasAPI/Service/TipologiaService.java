package com.demandasAPI.demandasAPI.Service;


import com.demandasAPI.demandasAPI.Model.DTO.TipologiaDTO;
import com.demandasAPI.demandasAPI.Model.Tipologia;
import com.demandasAPI.demandasAPI.Repository.TipologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipologiaService {

    @Autowired
    private TipologiaRepository tipologiaRepository;


    public Tipologia createTipologia(TipologiaDTO tipologiaDTO){
        Tipologia tipologia = Tipologia.builder()
                .tipologia(tipologiaDTO.getTipologia())
                .descripcion(tipologiaDTO.getDescripcion())
                .SubTipologia(tipologiaDTO.getSubTipologia())
                .build();
        return tipologiaRepository.save(tipologia);
    }

    public List<Tipologia> getAllTipologias(){
        return tipologiaRepository.findAll();
    }
    public Tipologia getTipologiaById(String id){
        return tipologiaRepository.findById(id).orElse(null);
    }
    public Tipologia updateTipologia(String id, TipologiaDTO tipologiaDTO){
        return tipologiaRepository.findById(id).map(tipologia -> {
            tipologia.setTipologia(tipologiaDTO.getTipologia());
            tipologia.setDescripcion(tipologiaDTO.getDescripcion());
            tipologia.setSubTipologia(tipologiaDTO.getSubTipologia());
            return tipologiaRepository.save(tipologia);
        }).orElse(null);
    }
    public void deleteTipologia(String id){
        tipologiaRepository.deleteById(id);
    }

}
