package com.climbing.zone.service;

import com.climbing.zone.domain.*;
import com.climbing.zone.repository.CardRepository;
import com.climbing.zone.repository.ClimberRepository;
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
    CardRepository cardRepository;
    ClimberRepository climberRepository;

    public List<Climbingroute> findAll() {

        return climbingrouteRepository.findAll();
    }

    public void deleteClimbingrouteById(Long id) {
        climbingrouteRepository.deleteClimbingrouteById(id);
    }

    public Long addRouteClimbing(String name, RouteType routeType, ZoneType zoneType, float latitude, float longitude) {
        Climbingroute climbingroute = new Climbingroute();
        climbingroute.setName(name);
        climbingroute.setRouteType(routeType);
        climbingroute.setZoneType(zoneType);
        climbingroute.setLatitude(latitude);
        climbingroute.setLongitude(longitude);
        climbingrouteRepository.save(climbingroute);

       Climber climber= climberRepository.findClimberById(1);



        Card card = new Card();
        CardPk cardPk = new CardPk();
        cardPk.setClimber(climber);
        cardPk.setClimbingroute(climbingroute);
        card.setId(cardPk);

        cardRepository.save(card);

        return climbingroute.getId();
    }
}



