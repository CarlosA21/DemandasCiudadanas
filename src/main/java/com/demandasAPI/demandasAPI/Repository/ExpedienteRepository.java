package com.demandasAPI.demandasAPI.Repository;

import com.demandasAPI.demandasAPI.Model.Expediente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpedienteRepository  extends MongoRepository<Expediente, String> {

}
