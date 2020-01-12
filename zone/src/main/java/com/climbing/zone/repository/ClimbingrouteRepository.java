package com.climbing.zone.repository;

import com.climbing.zone.domain.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

//sert a dialoguer avec la base de donnee





public interface ClimbingrouteRepository extends CrudRepository<Climbingroute, Long> {


    List<Climbingroute> findAll();
    //    @Async
    //    Future<Todo> findById(Long id);
    //@Query("select latitude from Climbingroute c where c.latitude >1")
    @Query("select c from Climbingroute c where c.latitude >1" )
    List<Climbingroute> findAround(@Param("lat")float lat);

    void deleteClimbingrouteById(Long id);


}

