package com.demandasAPI.demandasAPI.Repository;

import com.demandasAPI.demandasAPI.Model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}
