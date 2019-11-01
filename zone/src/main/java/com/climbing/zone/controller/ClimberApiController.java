package com.climbing.zone.controller;

import com.climbing.zone.domain.Climber;
import com.climbing.zone.domain.Topic;
import com.climbing.zone.service.ClimberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
// @restController pour generer les API
// pour ajouter api dans url avant chaque requete
//information affichée dans swagger
// @CrossOrigin(origins = "*")

@RestController
//@RequestMapping("api")
@Api(value = "Climber", tags = {"Api Climber: (findAll, AddUser, DeleteUser)"})
public class ClimberApiController {

    Logger logger = LoggerFactory.getLogger(ClimberApiController.class);
    //injecte le climberService sous forme de singleton patttern

    @Autowired
    ClimberService climberService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("==== in greeting ====");
        return new Greeting(1, name);
    }

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return climberService.getAllTopic();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable Long id){
        return climberService.getFirstTopic(id);
    }

    @RequestMapping("/topics/name/{name}")
    public Topic getTopicByName(@PathVariable String name){
        return climberService.getFirstTopicByName(name);
    }

    @RequestMapping("/topics/info/{info}")
    public Topic getTopicByInfo(@PathVariable String info){
        return climberService.getFirstTopicByInfo(info);
    }
    @RequestMapping(method=RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic){
        climberService.addTopic(topic);

    }

    //    //dans le path /climbers la variable de ce path est id
//    @CrossOrigin(origins = "http://localhost:4200")
//    @RequestMapping("/climbers/{id}")
//    public Climber findClimberById(@PathVariable Long id) {
//        return climberService.findClimberById(id);
//    }


//
//
//    @ApiOperation(value = "Ajoute un voie à un grimpeur", response = List.class)
//    @GetMapping("/AddClimberClimbingroute")
//
//    public void addClimbingroute(@RequestParam("idClimbingroute") Long idClimbingroute) {
//        logger.info("ajoute une voie au grimpeur courant");
//        climberService.addClimbingroute(idClimbingroute);
//    }
//
//    //recherche la liste de tous les utilisateurs
//    @CrossOrigin(origins = "http://localhost:4200")
//    @ApiOperation(value = "Affiche la liste des utilisateurs", response = List.class)
//    @GetMapping("/Climber")
//    public List<Climber> findAll() {
//        logger.info("affichage de tous les grimpeurs");
//        return climberService.findAll();
//    }
//    //ajoute un nouvel utilisateur
////    @ApiOperation(value = "Ajoute un nouvel Utilisateur (prenom, nom, date: jour, mois, année)")
////    @CrossOrigin(origins = "http://localhost:4200")
////    @PostMapping("/Climber/posts")
//    // @RequestParam(value = "params", required = false)
////    @RequestMapping(value = "/Climber/posts", method = RequestMethod.POST)
////    public Greeting addClimber(@RequestParam(required = false, defaultValue = "vide") String name) {
////        System.out.println("test" + name);
////       return climberService.addClimber(firstName, lastName, day, month, year);
////        return new Greeting(1, "oui");
////    }
//
//    //    @ResponseBody
//    @CrossOrigin(origins = "http://localhost:4200")
////    @PostMapping(value = "/posts/{id1}")
//    @RequestMapping(value = "test", method = POST)
//    @ResponseBody
//    public String addClimber() {
//        //return "ID: " + id1;
//        System.out.println(7);
//        climberService.addClimber("4", "1", 2, 2, 2);
//        return "test";
//    }
//    //efface un utilisateur par son id
//    @ApiOperation(value = "supprime un grimpeur")
//    @DeleteMapping("/Climber")
//    public void deleteClimberByIdClimber(@RequestParam("IdClimber") Long idClimber) {
//        logger.info("Admin :efface un utilisateur par son id");
//        climberService.deleteClimberByIdClimber(idClimber);
//    }
//
//    //affiche la liste des grimpeur par prenom
//    @ApiOperation(value = "Affiche la liste des utilisateurs par prenom", response = List.class)
//    @GetMapping("/Climber/firstName/{firstName}")
//    public List<Climber> findAllByFirstName(@PathVariable("firstName") String firstName) {
//        logger.info("affichage de tous les utilisateurs");
//        return climberService.findAllByFirstName(firstName);
//    }
//
//    //affiche la liste des grimpeur par prenom
//    @ApiOperation(value = "Affiche la liste des utilisateurs par id", response = List.class)
//    @GetMapping("/Climber/{IdClimber}")
//    public Climber findClimberByIdClimber(@PathVariable("IdClimber") Long IdClimber) {
//        logger.info("affichage de tous les utilisateurs");
//        return climberService.findClimberByIdClimber(IdClimber);
//    }
//
//    //affiche la liste des grimpeur par nom
//    @ApiOperation(value = "Affiche la liste des utilisateurs par nom", response = List.class)
//    @GetMapping("/Climber/lastName?{lastName}")
//    public List<Climber> findAllByLastName(@PathVariable("lastName") String lastName) {
//        logger.info("affichage de tous les utilisateurs par prenom");
//        return climberService.findAllByLastName(lastName);
//    }
}


