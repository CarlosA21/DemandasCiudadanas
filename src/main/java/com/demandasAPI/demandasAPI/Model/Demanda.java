package com.demandasAPI.demandasAPI.Model;


import lombok.Builder;
import lombok.Data;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document (collection = "Demandas")
@Data
@Builder
public class Demanda {

    @Id
    private ObjectId id_demanda;
    private int tipologia;
    private int demandante;
    @Field("clasificacion")
    private List<String> clasificacion;

    private  String descripcion;
    private Float latitud;
    private Float longitud;
    private int prioridad;

    private Binary imagen;
}
