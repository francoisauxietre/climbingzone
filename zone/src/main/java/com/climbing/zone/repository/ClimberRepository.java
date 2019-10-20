package com.climbing.zone.repository;

import com.climbing.zone.domain.Climber;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//sert a dialoguer avec la base de donnee

public interface ClimberRepository extends CrudRepository<Climber, Long> {

//    Long findId();
 //   Long findByIdClimber();
    List<Climber> findAll();
    void deleteClimberByIdClimber(Long idClimber);
    List<Climber>findByFirstName(String firstName);
    List<Climber>findByLastName(String lastName);
//    void addClimbingroute(Long idClimbingroute);

}

