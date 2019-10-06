package com.escalade.demo.controller;

import com.escalade.demo.domain.Route;
import com.escalade.demo.domain.RouteType;
import com.escalade.demo.domain.ZoneType;
import com.escalade.demo.service.RouteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController // genere les URI de notre API
@RequestMapping("api")
public class RouteController {

    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Access-Control-Allow-Origin","*");
    }

    @Autowired
    RouteService routeService;

    @ApiOperation(value = "recherche une voie")
    @GetMapping( value = "/Route/{id}")
    public String findRouteById(@PathVariable int id){
        String name = routeService.findById(id).getName();
        float latitude = routeService.findById(id).getLatitude();
        float longitude = routeService.findById(id).getLatitude();
        String routeType = routeService.findById(id).getRouteType().toString();
        String zoneType = routeService.findById(id).getZoneType().toString();
        //TODO convertir la liste des parking en string
        //List<String> ParkinsList = routeService.findAllByParking(routeService.findById(id)).toString();
        return "Voie :" +id + "\n nom "+name + "\n latitude:"+ latitude+ "\n longitude:"+ longitude+ " \n genre:" + routeType +"\n en:"+ zoneType;
    }
    @ApiOperation(value = "recherche les voies autour d'une coordonneGps(lat, long, distance)")
    @GetMapping( value = "/Route")
    //TODO faire un rayon sinon ou une box avec un parametre de latitude search et de longitude search
    public List<Route> findAllByLatitudeAfterAndLatitudeBeforeAndLongitudeAfterAndLongitudeBefore(@RequestParam float latitude,@RequestParam  float longitude,@RequestParam  float searchDistance){
        return routeService.findAllByLatitudeAfterAndLatitudeBeforeAndLongitudeAfterAndLongitudeBefore(
                latitude-searchDistance,
                latitude+searchDistance,
                longitude-searchDistance,
                longitude+searchDistance
        );
    }

    //ajout d'une voie
    @ApiOperation(value = "ajouter d'une voie")
    @PostMapping("/Route")
    public void addRoute(@RequestParam("name") String name,
                        @RequestParam("routeType") RouteType routeType,
                        @RequestParam("zoneType")ZoneType zoneType,
                        @RequestParam("latitude") int latitude,
                        @RequestParam("longitude") int longitude
    ) {
        Route route =  new Route(name, routeType, zoneType, latitude, longitude);
        routeService.addRoute(route);
    }



}
