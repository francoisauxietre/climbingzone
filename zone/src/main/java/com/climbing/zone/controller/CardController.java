package com.climbing.zone.controller;

import com.climbing.zone.service.CardService;
import com.climbing.zone.service.ClimberService;
import com.climbing.zone.service.ClimbingrouteService;
import com.climbing.zone.service.dto.CardDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController(value = "/cards")
@CrossOrigin(origins = {"http://localhost:4200", "http://angular7.auxietre.com", "http://localhost:8080"})
@Api(value = "card", tags = {"Api Cards"})
@RequestMapping("/cards")
public class CardController {

    @Autowired
    CardService cardService;

    @Autowired
    ClimberService climberService;

    @Autowired
    ClimbingrouteService climbingrouteService;


    @ApiOperation(value = "cards DTO")
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResponseEntity<List<CardDto>> findAll() {
        log.info("liste des cartes demandee");
        return new ResponseEntity<List<CardDto>>(cardService.findAll(), HttpStatus.OK);
    }
}
