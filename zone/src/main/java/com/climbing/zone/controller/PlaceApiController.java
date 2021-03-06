package com.climbing.zone.controller;

import com.climbing.zone.domain.Climber;
import com.climbing.zone.domain.Place;
import com.climbing.zone.service.PlaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
// @restController pour generer les API
@RestController
// pour ajouter api dans url avant chaque requete
@RequestMapping("api")
//information affichée dans swagger
@Api(value = "Place", tags = {"Api Place: (findAll, addPlace, DeletePlace)"})

public class PlaceApiController {


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
//    @ApiOperation(value = "Affiche la liste des lieux", response = List.class)
//    @GetMapping("/Place")
//    public List<Place> findAll() {
//        log.info("affichage de tous les lieux");
//        return placeService.findAll();
//    }


//  add @PostMapping("/Place") autre nommage mais moi clair pour moi
    @ApiOperation(value = "Ajoute un nouveau lieu (nom, latitude, logitude)")
    @RequestMapping(method = RequestMethod.POST, value = "/places")
    public void addPlace(
            @RequestParam(required = true, defaultValue = "rodellar") String name,
            @RequestParam(required = true, defaultValue = "42.282282") float latitude,
            @RequestParam(required = true, defaultValue = "-0.078619") float longitude){
        placeService.addPlace(name, latitude, longitude);
        log.info("GET on /places");
    }

    //efface un utilisateur par son id
//    @ApiOperation(value = "supprime un lieu")
//    @DeleteMapping("/Place")
//    public void deleteClimberByIdClimber(@RequestParam("IdPlace") Long idPlace) {
//        log.info("Admin :efface un lieu par son id");
//        placeService.deletePlaceByIdPlace(idPlace);
//    }
}


