package com.climbing.zone.controller;

import com.climbing.zone.domain.Climber;
import com.climbing.zone.domain.Topic;
import com.climbing.zone.service.ClimberService;

import com.climbing.zone.service.dto.ClimberDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
//    @Autowired
//    private Logger logger;
//
//    @ApiOperation(value = "Climbers DTO")
//    @RequestMapping(method = RequestMethod.GET, value = "/")
//    public ResponseEntity<List<CardDto>> findAll() {
//        logger.info("liste des cartes demandee");
//        return new ResponseEntity<List<CardDto>>(cardService.findAll(), HttpStatus.OK);


@RestController(value = "/climbers")
@CrossOrigin(origins = "http://localhost:4200")
@Api(value = "Climber", tags = {"Api Climbers"})
@RequestMapping("/climbers")
public class ClimberController {
    //pour les logs
//    Logger logger = LoggerFactory.getLogger(ClimberController.class);
    @Autowired
    Logger logger;

    //injecte le climberService sous forme de singleton patttern
    @Autowired
    ClimberService climberService;

    //-----------------------------------------CLIMBER---------------------------------------------------------------
    //get
    @ApiOperation(value = "Climbers DTO")
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResponseEntity<List<ClimberDto>> findAll() {
        logger.info("liste des cartes demandee");
        return new ResponseEntity<List<ClimberDto>>(climberService.findAll(), HttpStatus.OK);
    }

    //post
    @RequestMapping(method = RequestMethod.POST, value = "/")
    public Climber AddClimber(
            @RequestParam(required = true, defaultValue = "francois luc theotime") String firstName,
            @RequestParam(required = true, defaultValue = "auxietre guesdon") String lastName,
            @RequestParam(required = true, defaultValue = "18") Date date,
            @RequestParam(required = false, defaultValue = "bloc") String info) {
        logger.info("==== create new climber ====");
        return climberService.addClimber(firstName, lastName, date, info);
    }






    //-----------------------------------------GREETING---------------------------------------------------------------
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(required = false, defaultValue = "World") String name) {
        logger.info("==== in greeting ====");
        return new Greeting(1, name);
    }

    //-----------------------------------------TOPICS---------------------------------------------------------------
    @ApiOperation(value = "Topics", response = List.class) //show api in swagger
    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return climberService.getAllTopic();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable Long id) {
        return climberService.getFirstTopic(id);
    }

    @RequestMapping("/topics/name/{name}")
    public Topic getTopicByName(@PathVariable String name) {
        return climberService.getFirstTopicByName(name);
    }

    @RequestMapping("/topics/info/{info}")
    public Topic getTopicByInfo(@PathVariable String info) {
        return climberService.getFirstTopicByInfo(info);
    }

    //annotation RequestBody on lui passe l'object en direct
    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic) {
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


