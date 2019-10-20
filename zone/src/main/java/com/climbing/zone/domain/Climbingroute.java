package com.climbing.zone.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Climbingroute {

    Logger logger = LoggerFactory.getLogger(Climbingroute.class);

    Long IdClimbingroute;
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
    String info = "";


    public Climbingroute() {
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        this.createAt = date;
        logger.info("creation d'une nuovelle voie vide");
    }

    public Climbingroute(String name, Place place, RouteType routeType, ZoneType zoneType, float latitude, float longitude) {
        this.name = name;
        this.place = place;
        this.routeType = routeType;
        this.zoneType = zoneType;
        this.latitude = latitude;
        this.longitude = longitude;
        this.info = "nom de la voie: " + name + " site: " + place + " genre: " +  " endroit: " + zoneType;
        logger.info(info);
        this.info = "lattitude: " +latitude + "longitude: "+longitude;
        logger.info(info);
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

    //en cas de destruction
    @PreDestroy
    public void destroy() {
        logger.info("destruction de " + this.info);
    }

    //creation d'un Id pour la base de donne auto generer
    //ATTENTION BIEN METTRE LES @ SUR LES GETTERS
    @javax.persistence.Id
    @GeneratedValue
    public Long getId() {
        return IdClimbingroute;
    }

    //    <---------------SETTERS---------------->


    public void setId(Long idClimbingroute) {
        IdClimbingroute = idClimbingroute;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public void setRouteType(RouteType routeType) {
        this.routeType = routeType;
    }

    public void setZoneType(ZoneType zoneType) {
        this.zoneType = zoneType;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void setModifyAt(Date modifyAt) {
        this.modifyAt = modifyAt;
    }

    public void setDeleteAt(Date deleteAt) {
        this.deleteAt = deleteAt;
    }


}
