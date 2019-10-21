package com.climbing.zone.domain;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Entity
public class ClimberClimbingroute {
    Logger logger = LoggerFactory.getLogger(Climber.class);

    Long IdClimberClimbingroute;
    Climber climber;
    Climbingroute climbingroute;
    Date date;
    String info;



    public ClimberClimbingroute(){}

    public ClimberClimbingroute(Climber climber, Climbingroute climbingroute) {

        this.climber = climber;
        this.climbingroute = climbingroute;
        this.date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        logger.info("creation du grimpeur qui a fait cette voie");

    }

    public ClimberClimbingroute(Climber climber, Climbingroute climbingroute, java.sql.Date date, String info) {
        this.climber = climber;
        this.climbingroute = climbingroute;
        this.date = date;
        this.info = info;
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
    @Id
    @GeneratedValue
    public Long getIdClimberClimbingroute() {
        return IdClimberClimbingroute;
    }

    public void setIdClimberClimbingroute(Long idClimberClimbingroute) {
        IdClimberClimbingroute = idClimberClimbingroute;
    }

    @ManyToOne
    public Climber getClimber() {
        return climber;
    }

    public void setClimber(Climber climber) {
        this.climber = climber;
    }

    @ManyToOne
    public Climbingroute getClimbingroute() {
        return climbingroute;
    }

    public void setClimbingroute(Climbingroute climbingroute) {
        this.climbingroute = climbingroute;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
