package com.climbing.zone.service;

import com.climbing.zone.domain.Climber;
import com.climbing.zone.domain.Place;
import com.climbing.zone.repository.ClimberRepository;
import com.climbing.zone.repository.PlaceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class PlaceService {

    Logger logger = LoggerFactory.getLogger(Climber.class);

    @Autowired
    PlaceRepository placeRepository;


    public List<Place> findAll() {
        return placeRepository.findAll();
    }

    public Long addPlace(String name, float latitude, float longitude) {
        Place place = new Place();
        place.setName(name);
        place.setLatitude(latitude);
        place.setLongitude(longitude);
        placeRepository.save(place);
        return place.getIdPlace();
    }

    public void deletePlaceByIdPlace(Long idPlace) {
        placeRepository.deletePlaceByIdPlace(idPlace);

    }


    public List<Place> findAllByName(String name) {
        return placeRepository.findAllByName(name);
    }
 }



