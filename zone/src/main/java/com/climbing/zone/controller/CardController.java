package com.climbing.zone.controller;

import com.climbing.zone.service.CardService;
import com.climbing.zone.service.ClimberService;
import com.climbing.zone.service.ClimbingrouteService;
import com.climbing.zone.service.dto.CardDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/cards")
@CrossOrigin(origins = "http://localhost:4200")
@Api(value = "card", tags = {"Api Cards"})
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

    @ApiOperation(value = "cards DTO")
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResponseEntity<List<CardDto>> findAll() {
        logger.info("liste des cartes demandee");
        return new ResponseEntity<List<CardDto>>(cardService.findAll(), HttpStatus.OK);
    }
}
