package com.demandasAPI.demandasAPI.Controller;

import com.demandasAPI.demandasAPI.Model.DTO.UsuarioDTO;
import com.demandasAPI.demandasAPI.Model.Usuario;
import com.demandasAPI.demandasAPI.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario createUsuario(@RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.createUsuario(usuarioDTO);
    }

    @GetMapping
    public Iterable<Usuario> getAllusers(){
        return usuarioService.getAllusers();
    }

    @GetMapping("/{id}")
    public Usuario getuserById(@PathVariable String id){
        return usuarioService.getuserById(id);
    }

    @PutMapping("/{id}")
    public Usuario updateuser(@PathVariable String id, @RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.updateuser(id, usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteuser(@PathVariable String id){
        usuarioService.deleteuser(id);
    }
}
