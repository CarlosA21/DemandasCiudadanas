package com.demandasAPI.demandasAPI.Model.DTO;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;

@Data
@Builder
public class TipologiaDTO {
    private ObjectId id_tipologia;
    private String tipologia;
    private String descripcion;

    private int SubTipologia;
}
