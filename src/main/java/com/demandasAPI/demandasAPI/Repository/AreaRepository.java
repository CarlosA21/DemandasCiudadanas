package com.demandasAPI.demandasAPI.Repository;

import com.demandasAPI.demandasAPI.Model.Area;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AreaRepository extends MongoRepository<Area, String > {
}
