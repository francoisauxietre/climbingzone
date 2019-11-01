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

    public List<Climbingroute> findAll() {
        return climbingrouteRepository.findAll();
    }

    public void deleteClimbingrouteById(Long id) {
        climbingrouteRepository.deleteClimbingrouteById(id);
    }

    public Long addRouteClimbing(String name, RouteType routeType, ZoneType zoneType, float latitude, float longitude, String info) {
        Climbingroute climbingRoute = new Climbingroute();
        climbingRoute.setName(name);
        climbingRoute.setRouteType(routeType);
        climbingRoute.setZoneType(zoneType);
        climbingRoute.setLatitude(latitude);
        climbingRoute.setLongitude(longitude);
        climbingRoute.setInfo(info);
        climbingrouteRepository.save(climbingRoute);
        return climbingRoute.getId();
    }
}



