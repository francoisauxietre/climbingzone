package com.climbing.zone.repository;

import com.climbing.zone.domain.Climber;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//implementation du DAO DATA ACCES OBJECT sert a dialoguer avec la base de donnee
//En étendant simplement l’interface CrudRepository ,
// Spring Data JPA fournira les implémentations des méthodes CRUD du référentiel

public interface ClimberRepository extends CrudRepository<Climber, Long> {

    // normalement ca suffit si on met bien les Noms pour que spring fasse le lien
    List<Climber>findClimbersByFirstName(String firstName);
    Page<Climber> findAll();

//    Climber findClimberById(int id);

//    Climber addClimber(Climber climber);
//
//    Long findId();
//    Climber findClimberByIdClimber(Long idClimber);
//    List<Climber> findAll();
//
//    void deleteClimberByIdClimber(Long idClimber);//Dmoain Specific Language
//    List<Climber>findByFirstName(String firstName);
//    List<Climber>findByLastName(String lastName);


//    void addClimbingroute(Long idClimbingroute);

}

