package com.climbing.zone.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name = "CARD")
@Data
public class Card implements Serializable {


    @EmbeddedId
    private CardPk id;

    @Column(name = "bonus")
    private String bonus;

    @Column(name = "info")
    private String info;

    @Column(name = "photo")
//    private Blob photo;
    private String photo;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    @Column(name = "difficuty")
    private String difficuty;

    @Column(name = "physical")
    private Integer physical;

    @Column(name = "technical")
    private Integer technical;

    @Column(name = "tactical")
    private Integer tactical;

    @Column(name = "mental")
    private Integer mental;

    @Column(name= "qrcode" )
//    private Blob qrcode;
    private String qrcode;

}
