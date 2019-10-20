package com.climbing.zone.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
public class Card {

    Logger logger = LoggerFactory.getLogger(Climber.class);

    Long IdCard; //id autogenerer

    String name;
    int physique;
    int technique;
    int tactique;
    int mental;

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

    public Card(String name, int physique, int technique, int tactique, int mental) {
        this.name = name;
        this.physique = physique;
        this.technique = technique;
        this.tactique = tactique;
        this.mental = mental;
        this.info = "nom:" + name + physique + "  " + technique + " " + tactique+ " "+  mental;
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
    public Long getIdCard() {
        return IdCard;
    }

    public void setIdCard(Long idCard) {
        IdCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhysique() {
        return physique;
    }

    public void setPhysique(int physique) {
        this.physique = physique;
    }

    public int getTechnique() {
        return technique;
    }

    public void setTechnique(int technique) {
        this.technique = technique;
    }

    public int getTactique() {
        return tactique;
    }

    public void setTactique(int tactique) {
        this.tactique = tactique;
    }

    public int getMental() {
        return mental;
    }

    public void setMental(int mental) {
        this.mental = mental;
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
                "name='" + name + '\'' +
                ", physique=" + physique +
                ", technique=" + technique +
                ", tactique=" + tactique +
                ", mental=" + mental +
                ", createAt=" + createAt +
                ", modifyAt=" + modifyAt +
                ", deleteAt=" + deleteAt +
                '}';
    }
}
