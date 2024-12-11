package com.demandasAPI.demandasAPI.Repository;

import com.demandasAPI.demandasAPI.Model.Subtipologia;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubtipologiaRepository extends MongoRepository <Subtipologia, String>{
}
