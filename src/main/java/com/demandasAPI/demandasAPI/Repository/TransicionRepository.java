package com.demandasAPI.demandasAPI.Repository;


import com.demandasAPI.demandasAPI.Model.Transicion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransicionRepository extends MongoRepository<Transicion, String> {
}
