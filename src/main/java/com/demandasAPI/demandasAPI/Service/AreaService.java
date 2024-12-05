package com.demandasAPI.demandasAPI.Service;

import com.demandasAPI.demandasAPI.Model.Area;
import com.demandasAPI.demandasAPI.Model.DTO.AreaDTO;
import com.demandasAPI.demandasAPI.Repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService {

    @Autowired
    private AreaRepository areaRepository;

    public Area createArea(AreaDTO areaDTO){
        Area area = Area.builder()
                .nombre(areaDTO.getNombre())
                .usuarios(areaDTO.getUsuario())
                .referente(areaDTO.getReferente())
                .siguienteSubArea(areaDTO.getSiguienteSubArea())
                .build();
        return areaRepository.save(area);
    }
    public List<Area> getAllAreas(){
        return areaRepository.findAll();
    }

    public Area getAreaById(String id){
        return areaRepository.findById(id).orElse(null);
    }

    //Update area
    public Area updateArea(String id, AreaDTO areaDTO){
        return areaRepository.findById(id).map(area -> {
            area.setNombre(areaDTO.getNombre());
            area.setUsuarios(areaDTO.getUsuario());
            area.setReferente(areaDTO.getReferente());
            area.setSiguienteSubArea(areaDTO.getSiguienteSubArea());
            return areaRepository.save(area);
            
        }).orElse(null);
    }

    public void deleteArea(String id){
        areaRepository.deleteById(id);
    }
}
