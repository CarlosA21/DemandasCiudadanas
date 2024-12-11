package com.demandasAPI.demandasAPI.Repository;

import com.demandasAPI.demandasAPI.Model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    // Optional query to find by email
    Optional<Usuario> findFirstByEmail(String email);

}
