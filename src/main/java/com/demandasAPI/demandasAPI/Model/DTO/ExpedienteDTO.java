package com.demandasAPI.demandasAPI.Model.DTO;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;

import java.time.LocalDate;

@Data
@Builder
public class ExpedienteDTO {

    public ObjectId id_expediente;
    public int Demanda;
    public String caratula;
    public int estado ;
    private LocalDate apertura;
    private LocalDate cierre;
    public String resolucion;



}
