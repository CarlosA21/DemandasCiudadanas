package com.demandasAPI.demandasAPI.Model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Subtipologia")
public class Subtipologia {
    private ObjectId id_subtipologia;
    private int SiguienteSubTip;
}
