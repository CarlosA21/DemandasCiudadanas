package com.demandasAPI.demandasAPI.Model;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Estado")
@Data
@Builder
public class Estado {
    @Id
    private ObjectId id_estado;
    private String Situacion;
    private String Estado;
}
