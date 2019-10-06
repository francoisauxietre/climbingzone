package com.escalade.demo.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Parking {

    Logger logger = LoggerFactory.getLogger(Parking.class);

    // a chaque fois qu'on mettra un persist on va faire un log
    @PrePersist
    public void startLog() {
        logger.info("creation du parking en cours " + this.name);
    }

    @PostPersist
    public void stopLog() {
        logger.info("creation faite de " + this.name);
    }


    Long Id;
    String name;
    List<Route> routeList;
    float latitude;
    float longitude;
    Date createAt;
    Date modifyAt;
    Date deleteAt;

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
//ajout de fetch et de cascade
    @OneToMany(fetch =  FetchType.LAZY, mappedBy = "parking", cascade = CascadeType.ALL)
    public List<Route> getRouteList() {
        return routeList;
    }

    public void setRouteList(List<Route> route_de_reference) {
        this.routeList = route_de_reference;
    }


    //    getters et setters
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
}
