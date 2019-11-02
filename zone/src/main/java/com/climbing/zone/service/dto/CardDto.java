package com.climbing.zone.service.dto;

import lombok.*;

// lombox

//@FieldDefaults(level=AccessLevel.PRIVATE) //: passe tous les champs en private ;
@NoArgsConstructor //génère le constructeur sans argument et public ;
@AllArgsConstructor //génère le constructeur avec tous les arguments
@Getter //génère tous les getters sur les champs ;
@Setter //génère tous les setters sur les champs ;
@EqualsAndHashCode(of= {"climberLastName", "climberLastName", "star","level"}) // génère equals et hashCode (et d'autres méthodes) sur les champs donnés ;
@ToString(of= {"climberFirstName","climberLastName","star","level"}) //To String
public class CardDto {

    //passage des objet via Url et HTTP response

    private Long Id;
    private String climberFirstName;
    private String climberLastName;

    private int star;
    private String level;


}
