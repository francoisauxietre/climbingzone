package com.climbing.zone.controller;

import com.climbing.zone.domain.Climber;
import com.climbing.zone.repository.ClimberRepository;
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
@Api(value = "Climber", tags = {"Api Climber: (findAll, AddUser, DeleteUser)"})

public class ClimberApiController {
    Logger logger = LoggerFactory.getLogger(ClimberApiController.class);

    //pour eviter le cache dans chrome et etre obliger d'aller le vider a la main
    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Access-Control-Allow-Origin", "*");
    }

    //pourra etre enlever apres dans notre api
//    @RequestMapping(value = "test")
//    public String test() {
//        return "SUCCESS";
//    }


    //lie au service du climber
    @Autowired
//    ClimberRepository climberRepository;
    ClimberService climberService;

    //recherche la liste de tous les utilisateurs
    @ApiOperation(value = "Affiche la liste des utilisateurs", response = List.class)
    @GetMapping("/Climber")
    public List<Climber> findAll() {
        logger.info("affichage de tous les grimpeurs");
        return climberService.findAll();
    }

    //ajoute un nouvel utilisateur
    @ApiOperation(value = "Ajoute un nouvel Utilisateur (prenom, nom, date: jour, mois, année")
    @PostMapping("/Climber")
    public Long addUser(@RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName,
                        @RequestParam("day") int day,
                        @RequestParam("month") int month,
                        @RequestParam("year") int year){

        return climberService.addClimber(firstName, lastName, day, month, year);
    }
}
