package com.climbing.zone.controller;

import com.climbing.zone.domain.Climber;
import com.climbing.zone.repository.ClimberRepository;
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
@Api(value = "Climber", tags = {"Api Climber: (GetUser, AddUser, DeleteUser"})

public class ClimberApiController {
    Logger logger = LoggerFactory.getLogger(ClimberApiController.class);

    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Access-Control-Allow-Origin", "*");
    }

    @RequestMapping(value = "test")
    public String test() {
        return "SUCCESS";
    }


    //lie au service du climber
    @Autowired
    ClimberRepository climberRepository;

    //recherche la liste de tous les utilisateurs
    @ApiOperation(value = "Affiche la liste des utilisateurs", response = List.class)
    @GetMapping("/Climber")
    public List<Climber> findAll() {
        logger.info("affichage de tous les grimpeurs");
        return climberRepository.findAll();
    }

}
