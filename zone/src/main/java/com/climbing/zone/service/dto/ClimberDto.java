package com.climbing.zone.service.dto;

import com.climbing.zone.domain.Card;
import com.climbing.zone.domain.Climber;
import com.climbing.zone.enumeration.Language;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@NoArgsConstructor //génère le constructeur sans argument et public ;
@AllArgsConstructor //génère le constructeur avec tous les arguments
@Getter //génère tous les getters sur les champs ;
@Setter //génère tous les setters sur les champs ;
@EqualsAndHashCode(of = {"id", "firstName"})
// génère equals et hashCode (et d'autres méthodes) sur les champs donnés ;
@ToString(of = {"firstName", "lastName"}) //To String
public class ClimberDto implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private Date birth;
    private Date createdAt;
    private Date modifiedAt;
    private Date deletedAt;
    private Language language;
    private Long cardsId;
    private Long openById;
    private Set<ClimberDto> friends = new HashSet<>();


    public ClimberDto(Climber climber) {
        toDTO(climber);
    }
    private Long sessionId;

    public static List<ClimberDto> toDTO(Iterable<Climber> all) {
        List<ClimberDto> climberDtoList = new ArrayList<>();
        for (Climber climber : all) {
            climberDtoList.add(new ClimberDto(climber));
        }
        return climberDtoList;
    }

    public void toDTO(Climber climber) {
        this.id = climber.getId();
        this.firstName = climber.getFirstName();
        this.lastName = climber.getLastName();
        this.birth= climber.getBirth();
        this.createdAt = climber.getCreatedAt();
//        this.friends = climber.getFriends();
    }


    public Climber fromDTO(ClimberDto climberDto){
        sessionId = (long) (Math.random()*100);
        Date date = new Date(System.currentTimeMillis());
        Climber climber = new Climber();
        climber.setFirstName( climberDto.getFirstName());
        climber.setLastName(climberDto.getLastName());
        climber.setBirth(climberDto.getBirth());
        climber.setLanguage(climberDto.getLanguage());
        climber.setCreatedAt(date);

        return climber;
    }
}
