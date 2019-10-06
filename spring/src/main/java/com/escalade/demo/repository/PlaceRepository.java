package com.escalade.demo.repository;

import com.escalade.demo.domain.Place;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlaceRepository extends CrudRepository<Place, Long> {

    Place findByName(String name);
    List<Place> findAllByName(String name);
    List<Place> findAllByLatitudeAfterAndLatitudeBeforeAndLongitudeAfterAndLongitudeBefore(float firstLat, float lastLat, float firstLong, float lastLong);
    void deleteByName(String name);

}
