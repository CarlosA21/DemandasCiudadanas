package com.demandasAPI.demandasAPI.Model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "Usuario")
@Data
@Builder

public class Usuario {
    @Id
    @JsonSerialize(using = ToStringSerializer.class) // Automatically convert ObjectId to String
    private ObjectId id_usuario;
    private String nombre;
    private String apellido;
    private int documento;
    private String Barrio;
    private String Domicilio;

    @Indexed(unique = true)
    private String email;

    private String Clave;
    private String Rol;

}
