package com.climbing.zone.repository;

import com.climbing.zone.domain.Climber;
import com.climbing.zone.domain.Place;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlaceRepository extends CrudRepository<Place, Long> {

//    List<Place> findAll();
//    void deletePlaceByIdPlace(Long idPlace);
//    List<Place>findAllByName(String name);

}
