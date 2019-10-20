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
public class ClimberClimbingroute {
    Logger logger = LoggerFactory.getLogger(Climber.class);

    Long IdClimberClimbingroute;
    Long IdClimber;
    Long IdClimbingroute;
    Date date;
    String info;



    public ClimberClimbingroute(Long idClimber, Long idClimbingroute) {

        IdClimber = idClimber;
        IdClimbingroute = idClimbingroute;
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        this.date = date;
        logger.info("creation du grimpeur qui a fait cette voie");

    }

    // a chaque fois qu'on fera un nouvel ajout d'un grimpeur on aura cette merthode qui ajoutera des infos
    @PrePersist
    public void startLog() {
        logger.info("Création de l'utilisateur en cours ");
    }

    // a la fin de la creation
    @PostPersist
    public void stopLog() {
        logger.info("création terminée " + this.info);
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
    public Long getIdClimberClimbingroute() {
        return IdClimberClimbingroute;
    }

    public void setIdClimberClimbingroute(Long idClimberClimbingroute) {
        IdClimberClimbingroute = idClimberClimbingroute;
    }

    public Long getIdClimber() {
        return IdClimber;
    }

    public void setIdClimber(Long idClimber) {
        IdClimber = idClimber;
    }

    public Long getIdClimbingroute() {
        return IdClimbingroute;
    }

    public void setIdClimbingroute(Long idClimbingroute) {
        IdClimbingroute = idClimbingroute;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
