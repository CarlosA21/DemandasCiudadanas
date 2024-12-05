package com.demandasAPI.demandasAPI.Model;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Transicion")
@Data
@Builder

public class Transicion {
    private ObjectId id_transicion;
    private int Responsable;
    private int Estado;
    private List<String> lista;
}
