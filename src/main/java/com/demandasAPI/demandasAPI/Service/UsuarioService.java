package com.demandasAPI.demandasAPI.Service;

import com.demandasAPI.demandasAPI.Model.DTO.UsuarioDTO;
import com.demandasAPI.demandasAPI.Model.Usuario;
import com.demandasAPI.demandasAPI.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Crear usuario
    public Usuario createUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = Usuario.builder()
                .id_usuario(usuarioDTO.getId_usuario())
                .nombre(usuarioDTO.getNombre())
                .apellido(usuarioDTO.getApellido())
                .documento(usuarioDTO.getDocumento())
                .Barrio(usuarioDTO.getBarrio())
                .Domicilio(usuarioDTO.getDomicilio())
                .email(usuarioDTO.getEmail())
                .Clave(usuarioDTO.getClave())
                .Rol(usuarioDTO.getRol())
                .build();

        return usuarioRepository.save(usuario);
    }
    //Obtener todos los usuarios
    public List<Usuario> getAllusers(){
        return usuarioRepository.findAll();
    }

    //Obtener por ID
    public Usuario getuserById(String id){
        return usuarioRepository.findById(id).orElse(null);
    }

    //Actualizar Usuario
    public Usuario updateuser(String id, UsuarioDTO usuarioDTO){
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNombre(usuarioDTO.getNombre());
            usuario.setApellido(usuarioDTO.getApellido());
            usuario.setDocumento(usuarioDTO.getDocumento());
            usuario.setBarrio(usuarioDTO.getBarrio());
            usuario.setDomicilio(usuarioDTO.getDomicilio());
            usuario.setEmail(usuarioDTO.getEmail());
            usuario.setClave(usuarioDTO.getClave());
            usuario.setRol(usuarioDTO.getRol());
            return usuarioRepository.save(usuario);
        }).orElse(null);
    }
    //Borrar Usuario
    public void deleteuser(String id){
        usuarioRepository.deleteById(id);
    }

}

/* {
    "nombre": "Carlos Ariel",
    "apellido" : "De los santos ceballo",
    "documento" : 7542123,
    "Barrio": "Las charcas",
    "Domicilio": "7A",
    "email": "carlosariel58@gmail.com",
    "clave": "c3242019732001",
    "Rol": "ADMIN"
}*/
