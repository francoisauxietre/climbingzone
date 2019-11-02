package com.climbing.zone.service.dto;

import lombok.*;

import java.io.Serializable;

// lombox

//@FieldDefaults(level=AccessLevel.PRIVATE) //: passe tous les champs en private ;
@NoArgsConstructor //génère le constructeur sans argument et public ;
@AllArgsConstructor //génère le constructeur avec tous les arguments
@Getter //génère tous les getters sur les champs ;
@Setter //génère tous les setters sur les champs ;
@EqualsAndHashCode(of = {"id", "cardId", "climberFirstName", "climberLastName"})
// génère equals et hashCode (et d'autres méthodes) sur les champs donnés ;
public class CardDto implements Serializable {

    private Long id;
    private Long cardId;
    private Integer star;
    private String level;
    private String qrcode;
    private Integer climberPlace;
    private Integer climberTotal;
    private String place;
    private String photo;
    private String climbingRouteName;
    private Integer physical;
    private Integer technical;
    private Integer tactical;
    private Integer mental;
    private String bonus;
    private String climberFirstName;
    private String climberLastName;
}