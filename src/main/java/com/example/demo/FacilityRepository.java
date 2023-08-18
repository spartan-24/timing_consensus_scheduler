package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FacilityRepository extends MongoRepository<Facility, String> {
    Optional<Facility> findFacilityByName( String name);

}
