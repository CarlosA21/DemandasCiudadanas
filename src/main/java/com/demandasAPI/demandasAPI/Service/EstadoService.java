package com.demandasAPI.demandasAPI.Service;


import com.demandasAPI.demandasAPI.Model.DTO.EstadoDTO;
import com.demandasAPI.demandasAPI.Model.Estado;
import com.demandasAPI.demandasAPI.Repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;


    public Estado createEstado(EstadoDTO estadoDTO){
        Estado estado = Estado.builder()
                .Situacion(estadoDTO.getSituacion())
                .Estado(estadoDTO.getEstado())
                .build();

        return estadoRepository.save(estado);
    }

    public List<Estado> getAllEstados(){
        return estadoRepository.findAll();
    }

    public Estado getEstadoById(String id){
        return estadoRepository.findById(id).orElse(null);
    }

    public Estado updateEstado(String id, EstadoDTO estadoDTO){
        return estadoRepository.findById(id).map(Estado ->{
            Estado.setSituacion(estadoDTO.getSituacion());
            Estado.setEstado(estadoDTO.getEstado());
            return estadoRepository.save(Estado);}).orElse(null);
    }

    public void deleteEstado(String id){
        estadoRepository.deleteById(id);
    }

}
