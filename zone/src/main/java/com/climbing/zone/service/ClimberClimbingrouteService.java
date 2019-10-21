package com.climbing.zone.service;

import com.climbing.zone.domain.Climber;
import com.climbing.zone.domain.ClimberClimbingroute;
import com.climbing.zone.domain.Climbingroute;
import com.climbing.zone.repository.CardRepository;
import com.climbing.zone.repository.ClimberClimbingrouteRepository;
import org.jboss.logging.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class ClimberClimbingrouteService {

    @Autowired
    ClimberClimbingrouteRepository climberClimbingrouteRepository;


    public List<Climbingroute> findClimbingrouteByIdClimber(Climber climber){
        List<ClimberClimbingroute> list =  climberClimbingrouteRepository.findAllByClimber(climber);
        List<Climbingroute> retour = new ArrayList<>();
        list.forEach(route -> retour.add(route.getClimbingroute()));
        return retour;
    };

    public Long addRelation(Climber climber, Climbingroute climbingroute, String info){
        ClimberClimbingroute climberClimbingroute = new ClimberClimbingroute(climber, climbingroute, new Date(System.currentTimeMillis()), info);
        climberClimbingrouteRepository.save(climberClimbingroute);
        return climberClimbingroute.getIdClimberClimbingroute();
    }

// @Query("SELECT id, nom, prix FROM Product p WHERE p.prix > :prixLimit")
//   List<Product>  chercherUnProduitCher(@Param("prixLimit") int prix);


//    public int ClimbingrouteClimbersCount(Long idClimbingroute){
//        return 0;
//    }

//
//    @Query("SELECT count (IdClimber) FROM ClimberClimbingroute WHERE idClimbingroute = :idClimbingroute AND date <= (SELECT date FROM ClimberClimbingroute WHERE idClimber = :idClimber AND ClimberClimbingroute = :ClimberClimbingroute) ")
//    public int ClimbingrouteClimberOrder(@Param("idClimbingroute", "idClimber")){
//        return 0;
//    }

}
