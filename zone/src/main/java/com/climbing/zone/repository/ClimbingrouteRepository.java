package com.climbing.zone.repository;

import com.climbing.zone.domain.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//sert a dialoguer avec la base de donnee

public interface ClimbingRouteRepository extends CrudRepository<ClimbingRoute, Long> {

    List<ClimbingRoute> findAll();
    void deleteClimbingRouteById(Long id);
    void deleteClimbingRouteByName(String name);
    List<ClimbingRoute>findByLatitudeAfterAndLatitudeBeforeAndLongitudeAfterAndLongitudeBefore(float lat1, float lat2, float long1, float long2);
    List<Parking> findAllByName(String name);
    List<ClimbingRoute> findAllByRouteType(RouteType routeType);
    List<ClimbingRoute> findAllByZoneType(ZoneType zoneType);
}

