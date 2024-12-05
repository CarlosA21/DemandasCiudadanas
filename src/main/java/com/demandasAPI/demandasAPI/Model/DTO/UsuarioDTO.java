package com.demandasAPI.demandasAPI.Model.DTO;


import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@Builder


public class UsuarioDTO {
    private ObjectId id_usuario;
    private String nombre;
    private String apellido;
    private int documento;
    private String Barrio;
    private String Domicilio;
    private String email;
    private String Clave;
    private String Rol;

}
