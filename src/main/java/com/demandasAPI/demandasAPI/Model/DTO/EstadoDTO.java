package com.demandasAPI.demandasAPI.Model.DTO;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@Builder
public class EstadoDTO {
    private ObjectId id_estado;
    private String Situacion;
    private String Estado;
}
