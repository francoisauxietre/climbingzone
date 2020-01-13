package com.climbing.zone.controller;

import com.climbing.zone.domain.*;
import com.climbing.zone.enumeration.BonusType;
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
@CrossOrigin(origins = {"http://localhost:4200", "http://angular7.auxietre.com"})
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

    //affiche la liste des voies depuis un point gps latitude et longitude et une distance depuis ce moint
    //
    @ApiOperation(value = "Affiche la liste des voies depuis un centre (latitude, longitude) et un rayon (distance)", response = List.class)
    @GetMapping("/Climbingroute")
    public ResponseEntity<List<ClimbingrouteDto>> findAround(@RequestParam("latitude") float latitude,
                                                             @RequestParam("longitude") float longitude,
                                                             @RequestParam("distance") float distance) {
        log.info("affichage de toutes les voies à partir du point(lattitude, longitude, distance)");
        return new ResponseEntity<List<ClimbingrouteDto>>(climbingrouteService.findAround(latitude, longitude, distance), HttpStatus.OK);
    }

    //affiche la liste des voies ayant plus que x etoiles
    @ApiOperation(value = "Affiche la liste des voies ayant plus de X etoiles", response = List.class)
    @GetMapping("/Climbingroute/{id}")
    public ResponseEntity<List<ClimbingrouteDto>> findRouteByStar(@PathVariable("id") Integer id) {
        log.info("affichage de toutes les voies à partir du point(lattitude, longitude, distance)");
        return new ResponseEntity<List<ClimbingrouteDto>>(climbingrouteService.findRouteByStar(id), HttpStatus.OK);
    }

    //affiche la liste des voies par zone
    @ApiOperation(value = "Affiche la liste des voies par zoneType (EXTERIOR INTERIOR)", response = List.class)
    @GetMapping("/Climbingroute/zoneType/{zoneType}")
    public ResponseEntity<List<ClimbingrouteDto>> findAllByZoneType(@PathVariable("zoneType") ZoneType zoneType) {
        log.info("affichage de tous les voies par type de zone");
        return new ResponseEntity<List<ClimbingrouteDto>>(climbingrouteService.findAllByZoneType(zoneType), HttpStatus.OK);
    }

    //affiche la liste des voies par genre
    @ApiOperation(value = "Affiche la liste des voies par genre (BOULDER, ROUTE)", response = List.class)
    @GetMapping("/Climbingroute/routeType/{routeType}")
    public ResponseEntity<List<ClimbingrouteDto>> findAllByZoneType(@PathVariable("routeType") RouteType routeType) {
        log.info("affichage de tous les voies de type de route");
        return new ResponseEntity<List<ClimbingrouteDto>>(climbingrouteService.findAllByRouteType(routeType), HttpStatus.OK);
    }

    //affiche la liste des voies par difficulte exacte
    @ApiOperation(value = "Affiche la liste des voies par difficulte exacte", response = List.class)
    @GetMapping("/Climbingroute/difficulty/{id}")
    public ResponseEntity<List<ClimbingrouteDto>> findAllByDifficulty(@PathVariable("id") Integer id) {
        log.info("affichage de tous les voies de cette difficulte");
        return new ResponseEntity<List<ClimbingrouteDto>>(climbingrouteService.findAllByDifficulty(id), HttpStatus.OK);
    }

    //affiche la liste des voies ayant aumoins la difficulte
    @ApiOperation(value = "Affiche la liste des voies par difficulte au moins", response = List.class)
    @GetMapping("/Climbingroute/difficultyMin/{id}")
    public ResponseEntity<List<ClimbingrouteDto>> findAllByDifficultyMin(@PathVariable("id") Integer id) {
        log.info("affichage de tous les voies de cette difficulte au moins");
        return new ResponseEntity<List<ClimbingrouteDto>>(climbingrouteService.findAllByDifficultyMin(id), HttpStatus.OK);
    }

    //affiche la liste des voies ayant au plus la difficulte
    @ApiOperation(value = "Affiche la liste des voies par difficulte au plus", response = List.class)
    @GetMapping("/Climbingroute/difficultyMax/{id}")
    public ResponseEntity<List<ClimbingrouteDto>> findAllByDifficultyMax(@PathVariable("id") Integer id) {
        log.info("affichage de tous les voies de cette difficulte au plus");
        return new ResponseEntity<List<ClimbingrouteDto>>(climbingrouteService.findAllByDifficultyMax(id), HttpStatus.OK);
    }

    //affiche la liste des voies par bonus
    @ApiOperation(value = "Affiche la liste des voies par bonus (ROOF...)", response = List.class)
    @GetMapping("/Climbingroute/bonus/{bonusType}")
    public ResponseEntity<List<ClimbingrouteDto>> findAllByBonus(@PathVariable("bonusType") BonusType bonusType) {
        log.info("affichage de tous les voies par type de bonus");
        return new ResponseEntity<List<ClimbingrouteDto>>(climbingrouteService.findAllByBonus(bonusType), HttpStatus.OK);
    }

    //-----------------------------------------PHYSICAL---------------------------------------------------------------
    //affiche la liste des voies par
    @ApiOperation(value = "Affiche la liste des voies par physique", response = List.class)
    @GetMapping("/Climbingroute/physical/{id}")
    public ResponseEntity<List<ClimbingrouteDto>> findAllByPhysical(@PathVariable("id") Integer id) {
        log.info("affichage de tous les voies par niveau physique");
        return new ResponseEntity<List<ClimbingrouteDto>>(climbingrouteService.findAllByPhysical(id), HttpStatus.OK);
    }

    //affiche la liste des voies par
    @ApiOperation(value = "Affiche la liste des voies par technique au moins", response = List.class)
    @GetMapping("/Climbingroute/physicalMin/{id}")
    public ResponseEntity<List<ClimbingrouteDto>> findAllByPhysicalMin(@PathVariable("id") Integer id) {
        log.info("affichage de tous les voies par niveau physique");
        return new ResponseEntity<List<ClimbingrouteDto>>(climbingrouteService.findAllByPhysicalMin(id), HttpStatus.OK);
    }

    //affiche la liste des voies par
    @ApiOperation(value = "Affiche la liste des voies par technique au max", response = List.class)
    @GetMapping("/Climbingroute/physicalMax/{id}")
    public ResponseEntity<List<ClimbingrouteDto>> findAllByPhysicalMax(@PathVariable("id") Integer id) {
        log.info("affichage de tous les voies par niveau physique");
        return new ResponseEntity<List<ClimbingrouteDto>>(climbingrouteService.findAllByPhysicalMax(id), HttpStatus.OK);
    }

    //-----------------------------------------TACTICAL---------------------------------------------------------------
    //affiche la liste des voies par
    @ApiOperation(value = "Affiche la liste des voies par tactite", response = List.class)
    @GetMapping("/Climbingroute/tactical/{id}")
    public ResponseEntity<List<ClimbingrouteDto>> findAllByTactical(@PathVariable("id") Integer id) {
        log.info("affichage de tous les voies par niveau tactite");
        return new ResponseEntity<List<ClimbingrouteDto>>(climbingrouteService.findAllByTactical(id), HttpStatus.OK);
    }

    //affiche la liste des voies par
    @ApiOperation(value = "Affiche la liste des voies par tactite au moins", response = List.class)
    @GetMapping("/Climbingroute/tacticalMin/{id}")
    public ResponseEntity<List<ClimbingrouteDto>> findAllByTacticalMin(@PathVariable("id") Integer id) {
        log.info("affichage de tous les voies par niveau tactite");
        return new ResponseEntity<List<ClimbingrouteDto>>(climbingrouteService.findAllByTacticalMin(id), HttpStatus.OK);
    }

    //affiche la liste des voies par
    @ApiOperation(value = "Affiche la liste des voies par tactite au max", response = List.class)
    @GetMapping("/Climbingroute/tacticalMax/{id}")
    public ResponseEntity<List<ClimbingrouteDto>> findAllByTacticalMax(@PathVariable("id") Integer id) {
        log.info("affichage de tous les voies par niveau tactite");
        return new ResponseEntity<List<ClimbingrouteDto>>(climbingrouteService.findAllByTacticalMax(id), HttpStatus.OK);
    }

    //-----------------------------------------TECHNICAL---------------------------------------------------------------
    //affiche la liste des voies par
    @ApiOperation(value = "Affiche la liste des voies par technique", response = List.class)
    @GetMapping("/Climbingroute/technical/{id}")
    public ResponseEntity<List<ClimbingrouteDto>> findAllByTechnical(@PathVariable("id") Integer id) {
        log.info("affichage de tous les voies par niveau technique");
        return new ResponseEntity<List<ClimbingrouteDto>>(climbingrouteService.findAllByTechnical(id), HttpStatus.OK);
    }

    //affiche la liste des voies par
    @ApiOperation(value = "Affiche la liste des voies par technique au moins", response = List.class)
    @GetMapping("/Climbingroute/technicalMin/{id}")
    public ResponseEntity<List<ClimbingrouteDto>> findAllByTechnicalMin(@PathVariable("id") Integer id) {
        log.info("affichage de tous les voies par niveau technique");
        return new ResponseEntity<List<ClimbingrouteDto>>(climbingrouteService.findAllByTechnicalMin(id), HttpStatus.OK);
    }

    //affiche la liste des voies par
    @ApiOperation(value = "Affiche la liste des voies par technique au max", response = List.class)
    @GetMapping("/Climbingroute/technicalMax/{id}")
    public ResponseEntity<List<ClimbingrouteDto>> findAllByTechnicalMax(@PathVariable("id") Integer id) {
        log.info("affichage de tous les voies par niveau technique");
        return new ResponseEntity<List<ClimbingrouteDto>>(climbingrouteService.findAllByTechnicalMax(id), HttpStatus.OK);
    }

    //-----------------------------------------MENTAL---------------------------------------------------------------
    //affiche la liste des voies par
    @ApiOperation(value = "Affiche la liste des voies par mental", response = List.class)
    @GetMapping("/Climbingroute/mental/{id}")
    public ResponseEntity<List<ClimbingrouteDto>> findAllByMental(@PathVariable("id") Integer id) {
        log.info("affichage de tous les voies par niveau mental");
        return new ResponseEntity<List<ClimbingrouteDto>>(climbingrouteService.findAllByMental(id), HttpStatus.OK);
    }

    //affiche la liste des voies par
    @ApiOperation(value = "Affiche la liste des voies par mental au moins", response = List.class)
    @GetMapping("/Climbingroute/mentalMin/{id}")
    public ResponseEntity<List<ClimbingrouteDto>> findAllByMentalMin(@PathVariable("id") Integer id) {
        log.info("affichage de tous les voies par niveau mental");
        return new ResponseEntity<List<ClimbingrouteDto>>(climbingrouteService.findAllByMentalMin(id), HttpStatus.OK);
    }

    //affiche la liste des voies par
    @ApiOperation(value = "Affiche la liste des voies par mental au max", response = List.class)
    @GetMapping("/Climbingroute/mentalMax/{id}")
    public ResponseEntity<List<ClimbingrouteDto>> findAllByMentalMax(@PathVariable("id") Integer id) {
        log.info("affichage de tous les voies par niveau mental");
        return new ResponseEntity<List<ClimbingrouteDto>>(climbingrouteService.findAllByMentalMax(id), HttpStatus.OK);
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
//    //affiche la liste des parking
//    @ApiOperation(value = "Affiche la liste des parking", response = List.class)
//    @GetMapping("/Climbingroute/parking")
//    public List<Parking> findAllByName(@PathVariable("parking") String name) {
//        log.info("affichage de tous les parking");
//        return climbingrouteService.findAllByName(name);
//    }

}
