package com.climbing.zone.repository;

import com.climbing.zone.domain.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//sert a dialoguer avec la base de donnee

public interface ClimbingrouteRepository extends CrudRepository<Climbingroute, Long> {

    List<Climbingroute> findAll();


    void deleteClimbingrouteById(Long id);

}

