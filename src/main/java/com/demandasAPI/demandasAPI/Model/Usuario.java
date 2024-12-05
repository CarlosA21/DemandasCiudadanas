package com.demandasAPI.demandasAPI.Model;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "Usuario")
@Data
@Builder

public class Usuario {
    @Id
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
