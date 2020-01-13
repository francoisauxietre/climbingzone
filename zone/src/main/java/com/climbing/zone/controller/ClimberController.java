package com.climbing.zone.controller;

import com.climbing.zone.domain.Climber;
import com.climbing.zone.domain.Topic;
import com.climbing.zone.service.ClimberService;

import com.climbing.zone.service.dto.ClimberDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

// @restController pour generer les API
// pour ajouter api dans url avant chaque requete
//@RequestMapping("api")

//@RestController(value = "/cards")
//@CrossOrigin(origins = "http://localhost:4200")
//@Api(value = "card", tags = {"Api Card: (findAll, AddCard, DeleteCard)"})
//@RequestMapping("/cards")
//public class CardController {
//
//    @Autowired
//    CardService cardService;
//
//    @Autowired
//    ClimberService climberService;
//
//    @Autowired
//    ClimbingrouteService climbingrouteService;
//
//    @ApiOperation(value = "Climbers DTO")
//    @RequestMapping(method = RequestMethod.GET, value = "/")
//    public ResponseEntity<List<CardDto>> findAll() {
//        log.info("liste des cartes demandee");
//        return new ResponseEntity<List<CardDto>>(cardService.findAll(), HttpStatus.OK);

//TODO CHANGER ICI
@Slf4j
@RestController(value = "/climbers")
@CrossOrigin(origins = {"http://localhost:4200", "http://angular7.auxietre.com"})
@Api(value = "Climber", tags = {"Api Climbers"})
@RequestMapping("/climbers")
public class ClimberController {

    //injecte le climberService sous forme de singleton patttern
    @Autowired
    ClimberService climberService;

    //-----------------------------------------CLIMBER---------------------------------------------------------------
    //get
    @ApiOperation(value = "Climbers DTO")
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResponseEntity<List<ClimberDto>> findAll() {
        log.info("GET /climbers");
        return new ResponseEntity<List<ClimberDto>>(climberService.findAll(), HttpStatus.OK);
    }

    //post
    @ApiOperation(value = "Creation d'un nouveau grimpeur")
    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<String> createActivity(@RequestBody ClimberDto climberDto, Principal principal) {
        log.info("POST /climbers");
        Climber climber = climberDto.fromDTO(climberDto);
        climberService.save(climber);
        return new ResponseEntity<String>(new String(climber.getId() + ""), HttpStatus.OK);
    }

    //-----------------------------------------GREETING---------------------------------------------------------------
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(required = false, defaultValue = "World") String name) {
        log.info("GET /greeting");
        return new Greeting(1, name);
    }

    //-----------------------------------------TOPICS---------------------------------------------------------------
    @ApiOperation(value = "Topics", response = List.class) //show api in swagger
    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        log.info("GET /topics");
        return climberService.getAllTopic();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable Long id) {
        log.info("GET /topics/id");
        return climberService.getFirstTopic(id);
    }

    @RequestMapping("/topics/name/{name}")
    public Topic getTopicByName(@PathVariable String name) {
        log.info("GET /topics/name/{name}");
        return climberService.getFirstTopicByName(name);
    }

    @RequestMapping("/topics/info/{info}")
    public Topic getTopicByInfo(@PathVariable String info) {
        log.info("GET /topics/info/{info}");
        return climberService.getFirstTopicByInfo(info);
    }

    //annotation RequestBody on lui passe l'object en direct
    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic) {
        log.info("POST /topics");
        climberService.addTopic(topic);
    }

//
//    //get
//    @RequestMapping(method = RequestMethod.GET, value = "/climbers/firstName/{firstName}")
//    public List<Climber> findClimbersByFirstName(@PathVariable String firstName) {
//        return climberService.findClimbersByFirstName(firstName);
//    }
//
//    //get
//    @RequestMapping(method = RequestMethod.GET, value = "/climbers/lastName/{lastName}")
//    public List<Climber> findClimbersByLastName(@PathVariable String lastName) {
//        return climberService.findClimbersByLastName(lastName);
//    }
//

//
//    //update
//    @RequestMapping(method = RequestMethod.PUT, value = "/climbers/{value}")
//    public void updateClimber(
//            @RequestParam(required = true, defaultValue = "") String firstName,
//            @RequestParam(required = true, defaultValue = "") String lastName,
//            @RequestParam(required = true, defaultValue = "") int day,
//            @RequestParam(required = true, defaultValue = "") int month,
//            @RequestParam(required = true, defaultValue = "") int year,
//            @RequestParam(required = false, defaultValue = "") String info) {
//        climberService.update(firstName, lastName, day, month, year, info);
//    }
//
//    //delete
//    @RequestMapping(method = RequestMethod.DELETE, value = "/climbers/{value}")
//    public void delete(@PathVariable int value) {
//
//        climberService.delete(value);
//    }
//
//

//-----------------------------------------FRIENDS---------------------------------------------------------------

//    @GetMapping("/friends")
//    public List<Climber> findAllFriends() {
//        return climberService.findAllFriends();
//    }

//    @GetMapping("/climbers/test")
//    public Page<Climber> findAllClimbers(Pageable pageable) {
//        return climberService.findAll(pageable);
//    }
//        @RequestMapping(method = RequestMethod.POST, value = "/climbers")
//    public Climber addClimber(@RequestBody Climber climber) {
//        return climberService.addClimber(climber);
//    }

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
//        log.info("ajoute une voie au grimpeur courant");
//        climberService.addClimbingroute(idClimbingroute);
//    }
//
//    //recherche la liste de tous les utilisateurs
//    @CrossOrigin(origins = "http://localhost:4200")
//    @ApiOperation(value = "Affiche la liste des utilisateurs", response = List.class)
//    @GetMapping("/Climber")
//    public List<Climber> findAll() {
//        log.info("affichage de tous les grimpeurs");
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
//        log.info("Admin :efface un utilisateur par son id");
//        climberService.deleteClimberByIdClimber(idClimber);
//    }
//
//    //affiche la liste des grimpeur par prenom
//    @ApiOperation(value = "Affiche la liste des utilisateurs par prenom", response = List.class)
//    @GetMapping("/Climber/firstName/{firstName}")
//    public List<Climber> findAllByFirstName(@PathVariable("firstName") String firstName) {
//        log.info("affichage de tous les utilisateurs");
//        return climberService.findAllByFirstName(firstName);
//    }
//
//    //affiche la liste des grimpeur par prenom
//    @ApiOperation(value = "Affiche la liste des utilisateurs par id", response = List.class)
//    @GetMapping("/Climber/{IdClimber}")
//    public Climber findClimberByIdClimber(@PathVariable("IdClimber") Long IdClimber) {
//        log.info("affichage de tous les utilisateurs");
//        return climberService.findClimberByIdClimber(IdClimber);
//    }
//
//    //affiche la liste des grimpeur par nom
//    @ApiOperation(value = "Affiche la liste des utilisateurs par nom", response = List.class)
//    @GetMapping("/Climber/lastName?{lastName}")
//    public List<Climber> findAllByLastName(@PathVariable("lastName") String lastName) {
//        log.info("affichage de tous les utilisateurs par prenom");
//        return climberService.findAllByLastName(lastName);
//    }
}


