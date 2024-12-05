package com.demandasAPI.demandasAPI.Model;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.awt.geom.Area;
import java.util.List;
@Document(collection = "Flujo")
@Data
@Builder

public class Flujo {
    private ObjectId id_flujo;
    private String nombre;
    private String Descripcion;
    private int Area;
    private String actividades;
}
