package com.escalade.demo.repository;

import com.escalade.demo.domain.Parking;
import com.escalade.demo.domain.RouteType;
import com.escalade.demo.domain.ZoneType;
import com.escalade.demo.domain.Route;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RouteRepository extends CrudRepository<Route, Long> {
    List<Route> findAllByName(String name);
    List<Route> findAllByLatitudeAfterAndLatitudeBeforeAndLongitudeAfterAndLongitudeBefore(float firstLat, float lastLat, float firstLong, float lastLong);
    List<Parking> findAllByParking(Route parking);
    List<Route> findAllByRouteType(RouteType routeType);
    List<Route> findAllByZoneType(ZoneType zoneType);
    void deleteByName(String name);

}
