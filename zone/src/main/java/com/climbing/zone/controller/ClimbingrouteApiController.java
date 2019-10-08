package com.climbing.zone.controller;

import com.climbing.zone.domain.*;
import com.climbing.zone.service.ClimberService;
import com.climbing.zone.service.ClimbingRouteService;
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
@Api(value = "ClimbingRoute", tags = {"Api ClimbingRoute: (findAll, AddClimbingRoute, DeleteClimbingRoute)"})

public class ClimbingRouteApiController {

    Logger logger = LoggerFactory.getLogger(com.climbing.zone.controller.ClimberApiController.class);

    //pour eviter le cache dans chrome et etre obliger d'aller le vider a la main
    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Access-Control-Allow-Origin", "*");
    }

    //lie au service du climbingRoute
    @Autowired

    ClimbingRouteService climbingRouteService;

    //recherche la liste de tous les voies
    @ApiOperation(value = "Affiche la liste des voies", response = List.class)
    @GetMapping("/ClimbingRoute")
    public List<ClimbingRoute> findAll() {
        logger.info("affichage de tous les voies");
        return climbingRouteService.findAll();
    }

    //ajoute une nouvelle voie
    @ApiOperation(value = "Ajoute une nouvelle voie (nom, endroit, TypeDeVoie, TypeDeZone, latitude, longitude)")
    @PostMapping("/ClimbingRoute")
    public Long addRoute(@RequestParam("name") String name,
                         @RequestParam("place") Place place,
                         @RequestParam("routeType") RouteType routeType,
                         @RequestParam("zoneType") ZoneType zoneType,
                         @RequestParam("latitude") float latitude,
                         @RequestParam("longitude") float longitude
    ) {

        return climbingRouteService.addRouteClimbing(name, place, routeType, zoneType, latitude, longitude);
    }

    //efface un utilisateur par son id
    @ApiOperation(value = "supprime une voie")
    @DeleteMapping("/ClimbingRoute/id")
    public void deleteClimbingRoute(@RequestParam("Id") Long id) {
        logger.info("Admin :efface une voie");
        climbingRouteService.deleteClimbingRouteById(id);
    }

    //efface un utilisateur par son npm
    @ApiOperation(value = "supprime une voie depuis son nom")
    @DeleteMapping("/ClimbingRoute/name")
    public void deleteClimbingRoute(@RequestParam("name") String name) {
        logger.info("Admin :efface une voie");
        climbingRouteService.deleteClimbingRouteByName(name);
    }


    //affiche la liste des voies par latitudes et longitudes
    @ApiOperation(value = "Affiche la liste des voies dans une boite de latitude longitudes", response = List.class)
    @GetMapping("/ClimbingRoute/firstName/{lat1}&{lat2}&{long1}&{long2}")
    public List<ClimbingRoute> findRouteClimbingByBox(@PathVariable float lat1,
                                                      @PathVariable float lat2,
                                                      @PathVariable float long1,
                                                      @PathVariable float long2) {
        logger.info("affichage de toutes les voies");
        return climbingRouteService.findByLatitudeAfterAndLatitudeBeforeAndLongitudeAfterAndLongitudeBefore(lat1, lat2, long1, long2);
    }

    //affiche la liste des parking
    @ApiOperation(value = "Affiche la liste des parking", response = List.class)
    @GetMapping("/ClimbingRoute/parking")
    public List<Parking> findAllByName(@PathVariable("parking") String name) {
        logger.info("affichage de tous les parking");
        return climbingRouteService.findAllByName(name);
    }

    //affiche la liste des voies de type
    @ApiOperation(value = "Affiche la liste des voies de type", response = List.class)
    @GetMapping("/ClimbingRoute/routeType")
    public List<ClimbingRoute> findAllByRouteType(@PathVariable("routeType") RouteType routeType) {
        logger.info("affichage de tous les voies de type");
        return climbingRouteService.findAllByRouteType(routeType);
    }
    //affiche la liste des voies de zone
    @ApiOperation(value = "Affiche la liste des voies de zone", response = List.class)
    @GetMapping("/ClimbingRoute/zoneType")
    public List<ClimbingRoute> findAllByZoneType(@PathVariable("zoneType") ZoneType zoneType) {
        logger.info("affichage de tous les voies de zone");
        return climbingRouteService.findAllByZoneType(zoneType);
    }


}
