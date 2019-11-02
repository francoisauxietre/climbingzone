package com.climbing.zone.service.dto;

import com.climbing.zone.enumeration.Language;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

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
    private Instant birth;
    private Instant createdAt;
    private Instant modifiedAt;
    private Instant deletedAt;
    private Language language;
    private Long cardsId;
    private Long openById;
    private Set<ClimberDto> friends = new HashSet<>();
}
