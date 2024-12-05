package com.demandasAPI.demandasAPI.Service;


import com.demandasAPI.demandasAPI.Model.DTO.DemandaDTO;
import com.demandasAPI.demandasAPI.Model.Demanda;
import com.demandasAPI.demandasAPI.Repository.DemandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandaService {

    @Autowired
    private DemandaRepository demandaRepository;

    public Demanda createDemanda(DemandaDTO demandaDTO){
        Demanda demanda = Demanda.builder()
                .id_demanda(demandaDTO.getId_demanda())
                .tipologia(demandaDTO.getTipologia())
                .demandante(demandaDTO.getDemandante())
                .clasificacion(demandaDTO.getClasificacion())
                .descripcion(demandaDTO.getDescripcion())
                .latitud(demandaDTO.getLatitud())
                .longitud(demandaDTO.getLongitud())
                .prioridad(demandaDTO.getPrioridad())
                .imagen(demandaDTO.getImagen())
                .build();
        return demandaRepository.save(demanda);
    }
    //Get demandas
    public List<Demanda> getAllDemandas(){
        return demandaRepository.findAll();
    }
    //Get demandas por ID
    public Demanda getDemandaById(String id){
        return demandaRepository.findById(id).orElse(null);
    }
    //Actualizar demanda
    public Demanda updateDemanda(String id, DemandaDTO demandaDTO){
        return demandaRepository.findById(id).map(Demanda ->{
            Demanda.setTipologia(demandaDTO.getTipologia());
            Demanda.setDemandante(demandaDTO.getDemandante());
            Demanda.setClasificacion(demandaDTO.getClasificacion());
            Demanda.setDescripcion(demandaDTO.getDescripcion());
            Demanda.setLatitud(demandaDTO.getLatitud());
            Demanda.setLongitud(demandaDTO.getLongitud());
            Demanda.setPrioridad(demandaDTO.getPrioridad());
            Demanda.setImagen(demandaDTO.getImagen());
            return demandaRepository.save(Demanda);}).orElse(null);

    }
    //Borrar Demanda
    public void deleteDemanda(String id){
        demandaRepository.deleteById(id);
    }

}
