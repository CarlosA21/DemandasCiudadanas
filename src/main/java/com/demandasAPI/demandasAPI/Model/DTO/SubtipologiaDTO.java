package com.demandasAPI.demandasAPI.Model.DTO;


import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;

@Data
@Builder
public class SubtipologiaDTO {
    private ObjectId id_subtipologia;
    private int SiguienteSubTip;
}
