package com.demandasAPI.demandasAPI.Service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demandasAPI.demandasAPI.Model.DTO.ExpedienteDTO;
import com.demandasAPI.demandasAPI.Model.Expediente;
import com.demandasAPI.demandasAPI.Repository.ExpedienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.bson.types.ObjectId;


import java.util.List;


@Service
public class ExpedienteService {
    @Autowired
    private ExpedienteRepository expedienteRepository;

    private static final Logger logger = LoggerFactory.getLogger(ExpedienteService.class);

    @Transactional

    public Expediente createExpediente(ExpedienteDTO expedienteDTO) {
        Expediente expediente = Expediente.builder()
                .id_expediente(new ObjectId())
                .Demanda(expedienteDTO.getDemanda())
                .caratula(expedienteDTO.getCaratula())
                .estado(expedienteDTO.getEstado())
                .apertura(expedienteDTO.getApertura())
                .cierre(expedienteDTO.getCierre())
                .resolucion(expedienteDTO.getResolucion())
                .build();

        return expedienteRepository.save(expediente);
    }
    public List<Expediente> getAllExpedientes() {
        return expedienteRepository.findAll();
    }

    public Expediente getExpedienteById(String id) {
        return expedienteRepository.findById(id).orElse(null);
    }

    public Expediente updateExpediente(String id, ExpedienteDTO expedienteDTO) {
        return expedienteRepository.findById(id).map(expediente -> {
            expediente.setDemanda(expedienteDTO.getDemanda());
            expediente.setCaratula(expedienteDTO.getCaratula());
            expediente.setEstado(expedienteDTO.getEstado());
            expediente.setApertura(expedienteDTO.getApertura());
            expediente.setCierre(expedienteDTO.getCierre());
            expediente.setResolucion(expedienteDTO.getResolucion());
            return expedienteRepository.save(expediente);
        }).orElse(null);
    }

    public void deleteExpediente(String id) {
        expedienteRepository.deleteById(id);
    }


}
