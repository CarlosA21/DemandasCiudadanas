package com.demandasAPI.demandasAPI.Model.DTO;

import lombok.Builder;
import lombok.Data;
import org.bson.types.Binary;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@Builder
public class DemandaDTO {
    private ObjectId id_demanda;
    private int tipologia;
    private int demandante;
    private List<String> clasificacion;

    private  String descripcion;
    private Float latitud;
    private Float longitud;
    private int prioridad;

    private Binary imagen;
}
