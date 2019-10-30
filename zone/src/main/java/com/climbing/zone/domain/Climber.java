package com.climbing.zone.domain;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;
import javax.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Climber: les grimpeurs (nom, prenom, date de naissance, liste d amis, date de creation
 * date de modification, date de suppression
 */

@Entity
public class Climber {
    Logger logger = LoggerFactory.getLogger(Climber.class);

    Long IdClimber; //id autogenerer
    Long Id;
    String firstName; //prenom
    String lastName; // Nom
    Date birth; //anniversaire

    List<Climber> friendsList = new ArrayList<>(); //liste d'amis
    List<ClimberClimbingroute> climberClimbingroutes;

    Date createAt; //date de creation
    Date modifyAt; //date de modification
    Date deleteAt; //date de supression
    String info = "";


    // constructeur vide par default obligatoire
    public Climber() {
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        this.createAt = date;
        logger.info("creation d'un nouveau grimpeur vide");

    }

    //constructeur avec nom prenom et date de naissance
    public Climber(String firstName, String lastName, java.sql.Date birth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = birth;
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        this.createAt = date;
        this.info = "nom:" + lastName + "prenom" + firstName + "  " + lastName + " " + birth;
        this.Id = getIdClimber();
        logger.info(info);
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
    public Long getIdClimber() {
        return IdClimber;
    }

//    <---------------SETTERS---------------->


    public void setIdClimber(Long idClimber) {
        IdClimber = idClimber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
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

    public void setFriendsList(List<Climber> friendsList) {
        this.friendsList = friendsList;
    }


    //    <---------------GETTERS---------------->

//    @ManyToMany
//    @JsonBackReference // pour pas que il y ait un appel d'ami a un ami qui est un ami ....
//    @JoinTable(lastName = "friendsList")
//    public List<Climber> getFriendsList() {
//        return friendsList;
//    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // pour ne pas avoir des erreurs sur les dates de java
    @Basic
    @Temporal(value = TemporalType.DATE)
    public Date getBirth() {
        return birth;
    }


    @Override
    public String toString() {
        return "Climber{" +
                "IdClimber=" + IdClimber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birth=" + birth +
                '}';
    }


    @OneToMany(mappedBy = "climber")
    public List<ClimberClimbingroute> getClimberClimbingroutes() {
        return climberClimbingroutes;
    }

    public void setClimberClimbingroutes(List<ClimberClimbingroute> climberClimbingroutes) {
        this.climberClimbingroutes = climberClimbingroutes;
    }
}
