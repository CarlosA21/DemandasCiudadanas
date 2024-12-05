package com.demandasAPI.demandasAPI.Model;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "Area")
@Data
@Builder
public class Area {
    @Id
    private ObjectId id_area;
    private String nombre;
    private String usuarios;
    private int referente;
    private int siguienteSubArea;
}
