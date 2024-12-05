package com.demandasAPI.demandasAPI.Model.DTO;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransicionDTO {
    private int id_transicion;
    private int Responsable;
    private int Estado;
    private String lista;
}
