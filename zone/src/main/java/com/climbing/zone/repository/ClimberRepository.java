package com.climbing.zone.repository;

import com.climbing.zone.domain.Climber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

//sert a dialoguer avec la base de donnee

public interface ClimberRepository extends CrudRepository<Climber, Long> {

    List<Climber> findByLastName(String lastname);
}

