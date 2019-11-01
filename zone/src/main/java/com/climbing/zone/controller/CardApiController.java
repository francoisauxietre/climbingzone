package com.climbing.zone.controller;

import com.climbing.zone.domain.Card;
import com.climbing.zone.domain.Climber;
import com.climbing.zone.service.CardService;
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
@CrossOrigin(origins = "http://localhost:4200")
@Api(value = "card", tags = {"Api Card: (findAll, AddCard, DeleteCard)"})
public class CardApiController {

    Logger logger = LoggerFactory.getLogger(ClimberApiController.class);

    //pour eviter le cache dans chrome et etre obliger d'aller le vider a la main
    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Access-Control-Allow-Origin", "*");
    }

    //lie au service du card
    @Autowired
    CardService cardService;

    //recherche la liste de tous les cartes
    @ApiOperation(value = "Affiche la liste des cartes", response = List.class)
    @GetMapping("/cards")
    public List<Card> findAll() {
        logger.info("affichage de tous les grimpeurs");
        return cardService.findAll();
    }

    //ajoute un nouvelle carte
    @ApiOperation(value = "Ajoute un nouvelle carte (...)")
    @RequestMapping(method = RequestMethod.POST, value = "/cards")
    public Long addCard(
            @RequestParam(required = true, defaultValue = "1") int star,
            @RequestParam(required = true, defaultValue = "7a") String level,
            @RequestParam(required = true, defaultValue = "qrcode_") String qrcode,
            @RequestParam(required = true, defaultValue = "buis") String place,
            @RequestParam(required = true, defaultValue = "photo_")String photo,
            @RequestParam(required = true, defaultValue = "buis") String climbingRouteName,
            @RequestParam(required = true, defaultValue = "1")int physical,
            @RequestParam(required = true, defaultValue = "1")int technical,
            @RequestParam(required = true, defaultValue = "0")int tactical,
            @RequestParam(required = true, defaultValue = "1") int mental,
            @RequestParam(required = true, defaultValue = "Continuite resistance force endurance") String bonus,
            @RequestParam(required = true, defaultValue = "fafa")String climberFirstName,
            @RequestParam(required = true, defaultValue = "auxietre") String climberLastName,
            @RequestParam(required = true, defaultValue = "pas de bloc, gros toit, reta")String info) {
        return cardService.addCard(star, level, qrcode, place, photo, climbingRouteName, physical, technical, tactical, mental, bonus, climberFirstName, climberLastName, info);
    }

    //efface une carte par son id
    @ApiOperation(value = "supprime une carte")
    @DeleteMapping("/Card")
    public void deleteClimberByIdClimber(@RequestParam("Id") Long id) {
        logger.info("Admin :efface une carte par son id");
        cardService.deleteCardById(id);
    }
}
