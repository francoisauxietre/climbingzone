package com.climbing.zone.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PreDestroy;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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

    //autoIncrementation de la clé
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id; //id autogenerer

    @NotBlank(message = "FirstName is mantatory")
    String firstName; //prenom

    @NotBlank(message = "lastName is mantatory")
    String lastName; // Nom

    int day;
    int month;
    int year;
    Date createAt; //date de creation
    Date modifyAt; //date de modification
    Date deleteAt; //date de supression
    String info = "";
//    List<Climber> friendsList = new ArrayList<>(); //liste d'amis
//    List<ClimberClimbingroute> climberClimbingroutes;

    // constructeur vide par default obligatoire
    public Climber() {
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        this.createAt = date;
        logger.info("creation d'un nouveau grimpeur vide");
    }

    public Climber(String firstName, String lastName, int day, int month, int year, String info) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.day = day;
        this.month = month;
        this.year = year;
        this.info = info;
    }


//    @OneToMany(mappedBy = "climber")
//    public List<ClimberClimbingroute> getClimberClimbingroutes() {
//        return climberClimbingroutes;
//    }

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
    public Long getId() {
        return Id;
    }

//    <---------------SETTERS---------------->

    public void setId(Long id) {
        Id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
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

    public void setInfo(String info) {
        this.info = info;
    }

//    public void setFriendsList(List<Climber> friendsList) {
//        this.friendsList = friendsList;
//    }
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

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public Date getModifyAt() {
        return modifyAt;
    }

    public Date getDeleteAt() {
        return deleteAt;
    }

    public String getInfo() {
        return info;
    }

//    public List<Climber> getFriendsList() {
//        return friendsList;
//    }
//
//    public List<ClimberClimbingroute> getClimberClimbingroutes() {
//        return climberClimbingroutes;
//    }
}
