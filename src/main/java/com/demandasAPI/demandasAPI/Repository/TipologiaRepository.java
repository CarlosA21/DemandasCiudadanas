package com.demandasAPI.demandasAPI.Repository;

import com.demandasAPI.demandasAPI.Model.Tipologia;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipologiaRepository extends MongoRepository<Tipologia, String> {
}
