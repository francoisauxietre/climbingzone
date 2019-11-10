package com.climbing.zone.controller;

import com.climbing.zone.domain.Card;
import com.climbing.zone.service.CardService;
import com.climbing.zone.service.ClimberService;
import com.climbing.zone.service.ClimbingrouteService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/cards")
@CrossOrigin(origins = "http://localhost:4200")
@Api(value = "card", tags = {"Api Card: (findAll, AddCard, DeleteCard)"})
@RequestMapping("/cards")
public class CardController {

    @Autowired
    CardService cardService;

    @Autowired
    ClimberService climberService;

    @Autowired
    ClimbingrouteService climbingrouteService;

    @Autowired
    private Logger logger;





//    @Autowired private CardService cardService;
//
//    @RequestMapping(method = RequestMethod.GET)
//    public List<Card>getCards(){
//        return  this.cardService.findAll();
//    }

}
