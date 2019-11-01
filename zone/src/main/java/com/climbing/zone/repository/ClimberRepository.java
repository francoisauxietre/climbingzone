package com.climbing.zone.repository;

import com.climbing.zone.domain.Climber;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//sert a dialoguer avec la base de donnee

public interface ClimberRepository extends CrudRepository<Climber, Long> {

//    Long findId();
//    Climber findClimberByIdClimber(Long idClimber);
//    List<Climber> findAll();
//
//    void deleteClimberByIdClimber(Long idClimber);//Dmoain Specific Language
//    List<Climber>findByFirstName(String firstName);
//    List<Climber>findByLastName(String lastName);

    Climber findClimberById(int id);
//    void addClimbingroute(Long idClimbingroute);

}

