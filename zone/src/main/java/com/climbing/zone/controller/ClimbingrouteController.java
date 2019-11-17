package com.climbing.zone.controller;

import com.climbing.zone.domain.*;
import com.climbing.zone.service.ClimbingrouteService;
import com.climbing.zone.service.dto.ClimbingrouteDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Slf4j
@RestController(value = "/climbingroutes")
@CrossOrigin(origins = "http://localhost:4200")
@Api(value = "Climbingroute", tags = {"Api Climbing Routes"})
@RequestMapping("/climbingroutes")

public class ClimbingrouteController {


//pour eviter le cache dans chrome et etre obliger d'aller le vider a la main
//    @ModelAttribute
//    public void setResponseHeader(HttpServletResponse response) {
//        response.setHeader("Cache-Control", "no-cache");
//    }

    @Autowired
    ClimbingrouteService climbingrouteService;

    //-----------------------------------------CLIMBINGROUTE---------------------------------------------------------------
    //get
    @ApiOperation(value = "ClimingRoutes DTO")
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResponseEntity<List<ClimbingrouteDto>> findAll() {
        log.info("liste des voies demandee");
        return new ResponseEntity<List<ClimbingrouteDto>>(climbingrouteService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Creation d'une nouvelle climbing Route")
    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<String> createClimbingRoute(@RequestBody ClimbingrouteDto climbingrouteDto, Principal principal) {

        Climbingroute climbingroute = climbingrouteDto.fromDTO(climbingrouteDto);
        climbingrouteService.save(climbingroute);
        return new ResponseEntity<String>(new String(climbingroute.getId() + ""), HttpStatus.OK);
    }


//
//
//    //efface un utilisateur par son npm
//    @ApiOperation(value = "supprime une voie depuis son id")
//    @DeleteMapping("/Climbingroute/id")
//    public void deleteClimbingroute(@RequestParam("name") Long id) {
//        log.info("Admin :efface une voie");
//        climbingrouteService.deleteClimbingrouteById(id);
//    }
//(@PathVariable("firstName") String firstName)
//
//    //affiche la liste des voies par latitudes et longitudes
//    @ApiOperation(value = "Affiche la liste des voies dans une boite de latitude longitudes", response = List.class)
//    @GetMapping("/Climbingroute/{lat1}/{lat2}/{long1}/{long2}")
//    public List<Climbingroute> findRouteClimbingByBox(@PathVariable("lat1") float lat1,
//                                                      @PathVariable("lat2") float lat2,
//                                                      @PathVariable("long1") float long1,
//                                                      @PathVariable("long2") float long2) {
//        log.info("affichage de toutes les voies");
//        return climbingrouteService.findAllByLatitudeGreaterThanEqualAndLatitudeLessThanEqualAndLongitudeIsGreaterThanEqualAndLongitudeIsLessThanEqual(lat1, lat2, long1, long2);
//    }
//
//    //affiche la liste des parking
//    @ApiOperation(value = "Affiche la liste des parking", response = List.class)
//    @GetMapping("/Climbingroute/parking")
//    public List<Parking> findAllByName(@PathVariable("parking") String name) {
//        log.info("affichage de tous les parking");
//        return climbingrouteService.findAllByName(name);
//    }
//
//    //affiche la liste des voies de type
//    @ApiOperation(value = "Affiche la liste des voies de type", response = List.class)
//    @GetMapping("/Climbingroute/routeType")
//    public List<Climbingroute> findAllByRouteType(@PathVariable("routeType") RouteType routeType) {
//        log.info("affichage de tous les voies de type");
//        return climbingrouteService.findAllByRouteType(routeType);
//    }
//    //affiche la liste des voies de zone
//    @ApiOperation(value = "Affiche la liste des voies de zone", response = List.class)
//    @GetMapping("/Climbingroute/zoneType")
//    public List<Climbingroute> findAllByZoneType(@PathVariable("zoneType") ZoneType zoneType) {
//        log.info("affichage de tous les voies de zone");
//        return climbingrouteService.findAllByZoneType(zoneType);
//    }
}
