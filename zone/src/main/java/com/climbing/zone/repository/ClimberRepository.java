package com.climbing.zone.repository;

import com.climbing.zone.domain.Climber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

//sert a dialoguer avec la base de donnee

public interface ClimberRepository extends CrudRepository<Climber, Long> {

    List<Climber> findAll();
    void deleteUserById(Long id);
    List<Climber>findByFirstName(String firstName);
    List<Climber>findByLastName(String lastName);
}

