package com.climbing.zone.service;

import com.climbing.zone.domain.*;
import com.climbing.zone.repository.ClimbingrouteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClimbingrouteService {

    Logger logger = LoggerFactory.getLogger(Climber.class);

    @Autowired
    ClimbingrouteRepository climbingrouteRepository;


    /**
     * liste de toutes les voies
     * @return liste des voies
     */
    public List<Climbingroute> findAll() {
        return climbingrouteRepository.findAll();
    }

    public void deleteClimbingrouteById(Long id){
        climbingrouteRepository.deleteClimbingrouteById(id);

    }


    public Long addRouteClimbing(String name, Place place, RouteType routeType, ZoneType zoneType, float latitude, float longitude){
        Climbingroute climbingRoute = new Climbingroute();

        climbingRoute.setName(name);
        climbingRoute.setPlace(place);
        climbingRoute.setRouteType(routeType);
        climbingRoute.setZoneType(zoneType);
        climbingRoute.setLatitude(latitude);
        climbingRoute.setLongitude(longitude);
        climbingrouteRepository.save(climbingRoute);
        return climbingRoute.getId();
    }


//    public List<Climbingroute>findAllByLatitudeGreaterThanEqualAndLatitudeLessThanEqualAndLongitudeIsGreaterThanEqualAndLongitudeIsLessThanEqual(float lat1, float lat2, float long1, float long2){
//      return  climbingrouteRepository.findAllByLatitudeGreaterThanEqualAndLatitudeLessThanEqualAndLongitudeIsGreaterThanEqualAndLongitudeIsLessThanEqual(lat1, lat2, long1, long2);
//    }

//    public List<Parking> findAllByName(String name){
//       return climbingrouteRepository.findAllByName(name);
//    }
//
//    public List<Climbingroute> findAllByRouteType(RouteType routeType){
//        return climbingrouteRepository.findAllByRouteType(routeType);
//    }
//
//    public List<Climbingroute> findAllByZoneType(ZoneType zoneType){
//        return climbingrouteRepository.findAllByZoneType(zoneType);
//    }

}



