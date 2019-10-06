package com.escalade.demo.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Route {
    Logger logger = LoggerFactory.getLogger(Route.class);

    Long Id;
    String name;
    Place place;
    Parking parking;
    RouteType routeType;
    ZoneType zoneType;

    float latitude;
    float longitude;

    Date createAt;
    Date modifyAt;
    Date deleteAt;

    //faire toujours un constructeur par defaut au moment ou on en cree un avec parametres
    public Route() {
    }

    public Route(String name, RouteType routeType, ZoneType zoneType, int latitude, int longitude) {
        this.name = name;
        this.routeType = routeType;
        this.zoneType = zoneType;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    // a chaque fois qu'on mettra un persist on va faire un log
    @PrePersist
    public void logDebut() {
        logger.info("creation d'une voie en cours " + this.name);
    }

    @PostPersist
    public void logFin() {
        logger.info("creation faite de " + this.name);
    }



    @Id
    @GeneratedValue
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Enumerated(EnumType.STRING)
    public RouteType getRouteType() {
        return routeType;
    }

    public void setRouteType(RouteType routeType) {
        this.routeType = routeType;
    }

    @Enumerated(EnumType.STRING)
    public ZoneType getZoneType() {
        return zoneType;
    }

    public void setZoneType(ZoneType zoneType) {
        this.zoneType = zoneType;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getModifyAt() {
        return modifyAt;
    }

    public void setModifyAt(Date modifyAt) {
        this.modifyAt = modifyAt;
    }

    public Date getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(Date deleteAt) {
        this.deleteAt = deleteAt;
    }

    @ManyToOne
    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }
}
