package com.climbing.zone.controller;

import com.climbing.zone.domain.Card;
import com.climbing.zone.service.CardService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/cards")
@CrossOrigin(origins = "http://localhost:4200")
@Api(value = "card", tags = {"Api Card: (findAll, AddCard, DeleteCard)"})
public class CardController {

    @Autowired private CardService cardService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Card>getCards(){
        return  this.cardService.findAll();
    }

}
