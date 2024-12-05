package com.demandasAPI.demandasAPI.Repository;

import com.demandasAPI.demandasAPI.Model.Estado;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EstadoRepository extends MongoRepository <Estado, String>{
}
