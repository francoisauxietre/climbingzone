package com.climbing.zone.controller;

import com.climbing.zone.domain.Climber;
import com.climbing.zone.domain.ClimberClimbingroute;
import com.climbing.zone.domain.Climbingroute;
import com.climbing.zone.domain.Place;
import com.climbing.zone.service.CardService;
import com.climbing.zone.service.ClimberClimbingrouteService;
import com.climbing.zone.service.ClimberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

// @restController pour generer les API
@RestController
// pour ajouter api dans url avant chaque requete
@RequestMapping("api")
//information affichée dans swagger
@Api(value = "ClimberClimbingroute", tags = {"Api ClimberClimbingroute: ()"})

public class ClimberClimbingrouteApiController {

    Logger logger = LoggerFactory.getLogger(ClimberApiController.class);

    //pour eviter le cache dans chrome et etre obliger d'aller le vider a la main
    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Access-Control-Allow-Origin", "*");
    }

    //lie au service du card
    @Autowired
    ClimberClimbingrouteService climberClimbingrouteService ;

    @Autowired
    ClimberService climberService;

//    @Autowired
//    ClimberClimbingroute climberClimbingroute;


    //recherche la liste de tous les voies
    @ApiOperation(value = "Affiche le nombre de grimpeur ayant fait la voie", response = List.class)
    @GetMapping("/ClimberClimbingroute")

    public List<Climbingroute> findClimbingrouteByIdClimber(@RequestParam("id") Long idClimber) {
        logger.info("affichage de tous les voies faites par le grimpeur");
        Climber climber = climberService.findClimberByIdClimber(idClimber);
        return climberClimbingrouteService.findClimbingrouteByIdClimber(climber);
    }

    public Long addRelation(@RequestParam("idClimber") Long idClimber,
                            @RequestParam("idClimbingroute") Long idClimberoute,
                            @RequestParam("info") String info){
        Climber climber = climberService.findClimberByIdClimber(idClimber);
//        Climbingroute climbingroute = climberClimbingrouteService.findClimberById(idClimber);
        return new Long(0) ;
    }
}
