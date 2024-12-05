package com.demandasAPI.demandasAPI.Repository;

import com.demandasAPI.demandasAPI.Model.Flujo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FlujoRepository extends MongoRepository<Flujo, String> {
}
