package com.demandasAPI.demandasAPI.Model;


import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Tipologia")
@Data
@Builder
public class Tipologia {
    @Id
    private ObjectId id_tipologia;
    private String tipologia;
    private String descripcion;

    private int SubTipologia;
}
