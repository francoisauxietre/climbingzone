package com.climbing.zone.service;

import com.climbing.zone.domain.Climbingroute;
import com.climbing.zone.repository.CardRepository;
import com.climbing.zone.repository.ClimberClimbingrouteRepository;
import org.jboss.logging.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClimberClimbingrouteService {

    @Autowired
    ClimberClimbingrouteRepository climberClimbingrouteRepository;


    public List<Climbingroute> findClimbingrouteByIdClimber(Long idClimber){
        return null;
    };


// @Query("SELECT id, nom, prix FROM Product p WHERE p.prix > :prixLimit")
//   List<Product>  chercherUnProduitCher(@Param("prixLimit") int prix);


    public int ClimbingrouteClimbersCount(Long idClimbingroute){
        return 0;
    }

//
//    @Query("SELECT count (IdClimber) FROM ClimberClimbingroute WHERE idClimbingroute = :idClimbingroute AND date <= (SELECT date FROM ClimberClimbingroute WHERE idClimber = :idClimber AND ClimberClimbingroute = :ClimberClimbingroute) ")
//    public int ClimbingrouteClimberOrder(@Param("idClimbingroute", "idClimber")){
//        return 0;
//    }

}
