package com.demandasAPI.demandasAPI.Model.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FlujoDTO {
    private int id_flujo;
    private String nombre;
    private String Descripcion;
    private int Area;
    private String actividades;

}
