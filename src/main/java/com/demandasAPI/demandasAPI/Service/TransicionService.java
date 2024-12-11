package com.demandasAPI.demandasAPI.Service;


import com.demandasAPI.demandasAPI.Model.DTO.TransicionDTO;
import com.demandasAPI.demandasAPI.Model.Transicion;
import com.demandasAPI.demandasAPI.Repository.TransicionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransicionService {

    @Autowired
    private TransicionRepository transicionRepository;

    public Transicion createTransicion(TransicionDTO transicionDTO){
        Transicion transicion = Transicion.builder()
                .Responsable(transicionDTO.getResponsable())
                .Estado(transicionDTO.getEstado())
                .build();
        return transicionRepository.save(transicion);
    }
    public List<Transicion> getAllTransiciones(){
        return transicionRepository.findAll();
    }

    public Transicion getTransicionById(String id){
        return transicionRepository.findById(id).orElse(null);
    }
    public Transicion updateTransicion(String id, TransicionDTO transicionDTO){
        return transicionRepository.findById(id).map(transicion -> {
            transicion.setResponsable(transicionDTO.getResponsable());
            transicion.setEstado(transicionDTO.getEstado());
            return transicionRepository.save(transicion);
        }).orElse(null);
    }

    public void deleteTransicion(String id){
        transicionRepository.deleteById(id);
    }
}
