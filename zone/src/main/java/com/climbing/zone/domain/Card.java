package com.climbing.zone.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Card {

    Logger logger = LoggerFactory.getLogger(Climber.class);

    //autoIncrementation de la clé
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id; //id autogenerer

    @NotBlank(message = "FirstName is mantatory")
    String climberFirstName;

    @NotBlank(message = "lastName is mantatory")
    String climberLastName;

    int star;
    String level;
    String qrcode;
    int climberPlace;
    int climberTotal;
    String place;
    String photo;
    String climbingRouteName;
    int physical;
    int technical;
    int tactical;
    int mental;
    String bonus;

    Date createAt; //date de creation
    Date modifyAt; //date de modification
    Date deleteAt; //date de supression
    String info = "";

    // constructeur vide par default obligatoire
    public Card() {
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        this.createAt = date;
        logger.info("creation d'une nouvelle carte vide");
    }

    public Card(int star, String level, String qrcode, int climberPlace, int climberTotal, String place, String photo, String climbingRouteName, int physical, int technical, int tactical, int mental, String bonus, String climberFirstName, String climberLastName, Date createAt, String info) {
        this.star = star;
        this.level = level;
        this.qrcode = qrcode;
        this.climberPlace = climberPlace;
        this.climberTotal = climberTotal;
        this.place = place;
        this.photo = photo;
        this.climbingRouteName = climbingRouteName;
        this.physical = physical;
        this.technical = technical;
        this.tactical = tactical;
        this.mental = mental;
        this.bonus = bonus;
        this.climberFirstName = climberFirstName;
        this.climberLastName = climberLastName;
        this.createAt = createAt;
        this.info = "nom:" + climberLastName + physical + "  " + technical + " " + tactical + " " + mental;
        logger.info(info);
    }

    // a chaque fois qu'on fera un nouvel ajout d'un grimpeur on aura cette merthode qui ajoutera des infos
    @PrePersist
    public void startLog() {
        logger.info("Création d'une nouvelle carte en cours ");
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

    public void setId(Long id) {
        this.Id = id;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public int getClimberPlace() {
        return climberPlace;
    }

    public void setClimberPlace(int climberPlace) {
        this.climberPlace = climberPlace;
    }

    public int getClimberTotal() {
        return climberTotal;
    }

    public void setClimberTotal(int climberTotal) {
        this.climberTotal = climberTotal;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getClimbingRouteName() {
        return climbingRouteName;
    }

    public void setClimbingRouteName(String climbingRouteName) {
        this.climbingRouteName = climbingRouteName;
    }

    public int getPhysical() {
        return physical;
    }

    public void setPhysical(int physical) {
        this.physical = physical;
    }

    public int getTechnical() {
        return technical;
    }

    public void setTechnical(int technical) {
        this.technical = technical;
    }

    public int getTactical() {
        return tactical;
    }

    public void setTactical(int tactical) {
        this.tactical = tactical;
    }

    public int getMental() {
        return mental;
    }

    public void setMental(int mental) {
        this.mental = mental;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getClimberFirstName() {
        return climberFirstName;
    }

    public void setClimberFirstName(String climberFirstName) {
        this.climberFirstName = climberFirstName;
    }

    public String getClimberLastName() {
        return climberLastName;
    }

    public void setClimberLastName(String climberLastName) {
        this.climberLastName = climberLastName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Basic
    @Temporal(value = TemporalType.DATE)
    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Basic
    @Temporal(value = TemporalType.DATE)
    public Date getModifyAt() {
        return modifyAt;
    }

    public void setModifyAt(Date modifyAt) {
        this.modifyAt = modifyAt;
    }

    @Basic
    @Temporal(value = TemporalType.DATE)
    public Date getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(Date deleteAt) {
        this.deleteAt = deleteAt;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + climberLastName + '\'' +
                ", physique=" + physical +
                ", technique=" + technical +
                ", tactique=" + tactical +
                ", mental=" + mental +
                ", createAt=" + createAt +
                ", modifyAt=" + modifyAt +
                ", deleteAt=" + deleteAt +
                '}';
    }
}
