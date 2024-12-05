package com.demandasAPI.demandasAPI.Model;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate; // Import for LocalDate


@Document(collection = "expediente")
@Data
@Builder
public class Expediente {

    @Id
    private ObjectId id_expediente;
    private int Demanda;
    private String caratula;
    private int estado ;
    private LocalDate apertura;
    private LocalDate cierre;
    private String resolucion;

}
