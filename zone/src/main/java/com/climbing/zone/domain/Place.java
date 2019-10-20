package com.climbing.zone.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

@Entity
public class Place {

    Long IdPlace;
    String name;
    float latitude;
    float longitude;

    Logger logger = LoggerFactory.getLogger(Place.class);

    // a chaque fois qu'on mettra un persist on va faire un log
    @PrePersist
    public void startLog(){
        logger.info("creation du place en cours " + this.name);
    }

    @PostPersist
    public void stopLog(){
        logger.info("creation faite de " + this.name);
    }


    public Place() {
    }

    public Place(String name, float latitude, float longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Id
    @GeneratedValue
//     getters et setters
    public Long getIdPlace() {
        return IdPlace;
    }

    public void setIdPlace(Long idPlace) {
        IdPlace = idPlace;
    }

    public String getName() {
        return name;
    }


    public void setName(String nom) {
        this.name = nom;
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

//    @OneToMany(mappedBy = "place")
//    public List<Route> getRoutesList() {
//        return routesList;
//    }
//
//    public void setRoutesList(List<Route> routesList) {
//        this.routesList = routesList;
//    }
}
