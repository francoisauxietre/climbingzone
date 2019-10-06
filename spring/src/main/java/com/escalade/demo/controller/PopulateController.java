package com.escalade.demo.controller;

import com.escalade.demo.domain.*;
import com.escalade.demo.service.PlaceService;
import com.escalade.demo.service.RouteService;
import com.escalade.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController // genere les URI de notre API
@RequestMapping("api")
public class PopulateController {

   private int compteur =0;
    @Autowired
    UserService userService;

    @Autowired
    RouteService routeService;

    @Autowired
    PlaceService placeService;


    @RequestMapping("/Populate")
    void populate(){
        ;
        Route route = new Route("test", RouteType.BOULDER, ZoneType.EXTERIEUR, 1, 1);
        Route route1 = new Route("test1", RouteType.BOULDER, ZoneType.EXTERIEUR, 2, 2);
        Route route2 = new Route("test2", RouteType.BOULDER, ZoneType.EXTERIEUR, 3, 3);
        Route route3 = new Route("test3", RouteType.BOULDER, ZoneType.EXTERIEUR, 4, 4);
        routeService.addRoute(route);
        routeService.addRoute(route1);
        routeService.addRoute(route2);
        routeService.addRoute(route3);
        userService.addUser("fa"+compteur, "auxietre"+compteur, getRandomInt(30)+1, getRandomInt(11)+1,getRandomInt(2020));
        userService.addUser("adrien"+compteur, "weyl"+compteur, getRandomInt(30)+1, getRandomInt(11)+1,getRandomInt(2020));
        userService.addUser("ke"+compteur, "les"+compteur, getRandomInt(30)+1, getRandomInt(11)+1,getRandomInt(2020));
        userService.addUser("flo"+compteur, "duch"+compteur, getRandomInt(30)+1, getRandomInt(11)+1,getRandomInt(2020));
        User user = userService.findByNameAndFirstName("fa"+compteur, "auxietre");
        User user2 = userService.findByNameAndFirstName("adrien"+compteur, "weyl");
        User user3 = userService.findByNameAndFirstName("ke"+compteur, "les");
        User user4 = userService.findByNameAndFirstName("flo"+compteur, "duc");
        userService.addFriendsList(user, "fa", "auxietre");
        userService.addFriendsList(user2, "fa", "auxietre");
        userService.addFriendsList(user3, "fa", "auxietre");
        Place place =  new Place("place1", getRandomInt(3), getRandomInt(5));
        placeService.addPlace(place);

        compteur++;
       // System.out.println("exporattion reussie");



    }

    private int getRandomInt(int max) {
        return (int) Math.floor(Math.random() * Math.floor(max));
    }
}
