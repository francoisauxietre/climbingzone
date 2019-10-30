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
// pour ajouter api dans url avant chaque requete
@RequestMapping("api")
//information affichée dans swagger
@Api(value = "card", tags = {"Api Card: (findAll, AddCard, Deletecard)"})
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
    @GetMapping("/Card")
    public List<Card> findAll() {
        logger.info("affichage de tous les grimpeurs");
        return cardService.findAll();
    }

    //ajoute un nouvelle carte
    @ApiOperation(value = "Ajoute un nouvelle carte (...)")
    @PostMapping("/Card")
    public Long addUser(
            @RequestParam("star") int star,
            @RequestParam("level") int level,
            @RequestParam("qrcode") String qrcode,
            @RequestParam("place") String place,
            @RequestParam("photo") String photo,
            @RequestParam("climbingRouteName") String climbingRouteName,
                        @RequestParam("physical") int physical,
                        @RequestParam("technical") int technical,
                        @RequestParam("tactical") int tactical,
                        @RequestParam("mental") int mental,
            @RequestParam("bonus") String bonus,
            @RequestParam("climberFirstName") String climberFirstName,
            @RequestParam("climberLastName") String climberLastName,
            @RequestParam("info") String info)

    {

        return cardService.addCard(star, level, qrcode, place, photo, climbingRouteName,physical, technical, tactical, mental, bonus, climberFirstName, climberLastName, info);
    }


    //efface une carte par son id
    @ApiOperation(value = "supprime une carte")
    @DeleteMapping("/Card")
    public void deleteClimberByIdClimber(@RequestParam("IdCard") Long idCard) {
        logger.info("Admin :efface une carte par son id");
        cardService.deleteCardByIdCard(idCard);
    }

}
