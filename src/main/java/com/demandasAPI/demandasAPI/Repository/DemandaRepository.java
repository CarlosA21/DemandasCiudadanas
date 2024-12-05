package com.demandasAPI.demandasAPI.Repository;

import com.demandasAPI.demandasAPI.Model.Demanda;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DemandaRepository extends MongoRepository <Demanda, String>{

}
