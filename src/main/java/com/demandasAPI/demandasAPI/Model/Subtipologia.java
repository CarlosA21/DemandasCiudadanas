package com.demandasAPI.demandasAPI.Model;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Subtipologia")

@Data
@Builder
public class Subtipologia {
    private ObjectId id_subtipologia;
    private int SiguienteSubTip;
}
