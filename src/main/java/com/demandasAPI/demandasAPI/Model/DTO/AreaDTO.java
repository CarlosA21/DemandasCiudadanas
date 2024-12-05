package com.demandasAPI.demandasAPI.Model.DTO;


import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class AreaDTO {
    private int id_area;
    private String nombre;
    private String usuario;
    private int referente;
    private int siguienteSubArea;
}
