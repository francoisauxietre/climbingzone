package com.climbing.zone.controller;

import com.climbing.zone.domain.Climber;
import com.climbing.zone.domain.Place;
import com.climbing.zone.service.ClimberService;
import com.climbing.zone.service.PlaceService;
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
@Api(value = "Place", tags = {"Api Place: (findAll, addPlace, DeletePlace)"})

public class PlaceApiController {
    Logger logger = LoggerFactory.getLogger(PlaceApiController.class);

    //pour eviter le cache dans chrome et etre obliger d'aller le vider a la main
    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Access-Control-Allow-Origin", "*");
    }

    //lie au service du climber
    @Autowired
    PlaceService placeService;

    //recherche la liste de tous les utilisateurs
    @ApiOperation(value = "Affiche la liste des lieux", response = List.class)
    @GetMapping("/Place")
    public List<Place> findAll() {
        logger.info("affichage de tous les lieux");
        return placeService.findAll();
    }

    //ajoute un nouvel utilisateur
    @ApiOperation(value = "Ajoute un nouveau lieu (nom, latitude, logitude)")
    @PostMapping("/Place")
    public Long addUser(@RequestParam("name") String name,
                        @RequestParam("latitude") float latitude,
                        @RequestParam("longitude") float longitude){

        return placeService.addPlace(name, latitude, longitude);
    }

    //efface un utilisateur par son id
    @ApiOperation(value = "supprime un lieu")
    @DeleteMapping("/Place")
    public void deleteClimberByIdClimber(@RequestParam("IdPalce") Long idPlace) {
        logger.info("Admin :efface un lieu par son id");
        placeService.deletePlaceByIdPlace(idPlace);
    }
}


