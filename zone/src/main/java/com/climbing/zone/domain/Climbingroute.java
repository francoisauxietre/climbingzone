package com.climbing.zone.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;
import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Climbingroute {

    Logger logger = LoggerFactory.getLogger(Climbingroute.class);

    //autoIncrementation de la clé
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;
    private RouteType routeType;
    private ZoneType zoneType;
    private float latitude;
    private float longitude;
    private Date createAt;
    private Date modifyAt;
    private Date deleteAt;
    private String info = "";

    //private List<ClimberClimbingroute> climberClimbingrouteList;

    public Climbingroute() {
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        this.createAt = date;
        logger.info("creation d'une nuovelle voie vide");
    }

    public Climbingroute(String name, RouteType routeType, ZoneType zoneType, float latitude, float longitude, String info) {
        this.name = name;
        this.routeType = routeType;
        this.zoneType = zoneType;
        this.latitude = latitude;
        this.longitude = longitude;
        this.info = info;
    }

    //creation d'un Id pour la base de donne auto generer
    //ATTENTION BIEN METTRE LES @ SUR LES GETTERS
    @javax.persistence.Id
    @GeneratedValue
    public Long getId() {
        return Id;
    }

    //    <---------------SETTERS---------------->

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RouteType getRouteType() {
        return routeType;
    }

    public void setRouteType(RouteType routeType) {
        this.routeType = routeType;
    }

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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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
}
