package com.climbing.zone.service.dto;

import com.climbing.zone.domain.Climbingroute;
import com.climbing.zone.enumeration.RouteType;
import com.climbing.zone.enumeration.ZoneType;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor //génère le constructeur sans argument et public ;
@AllArgsConstructor //génère le constructeur avec tous les arguments
@Getter //génère tous les getters sur les champs ;
@Setter //génère tous les setters sur les champs ;
@EqualsAndHashCode(of = {"id", "name"})
// génère equals et hashCode (et d'autres méthodes) sur les champs donnés ;
@ToString(of = {"name", "physical", "technical", "tactical", "mental"}) //To String
public class ClimbingrouteDto  implements Serializable {

    private Long id;
    private String name;
    private String bonus;
    private Float latitude;
    private Float longitude;
    private String difficulty;
    private Integer star;
    private Integer physical;
    private Integer technical;
    private Integer tactical;
    private Integer mental;
    private Date createdAt;
    private Date modifiedAt;
    private Date deletedAt;
    private RouteType routeType;
    private ZoneType zoneType;

    public ClimbingrouteDto(Climbingroute climbingroute) {
        toDTO(climbingroute);
    }

    public static List<ClimbingrouteDto> toDTO(Iterable<Climbingroute> all) {
        List<ClimbingrouteDto> climbingrouteDtoList = new ArrayList<>();
        for (Climbingroute climbingroute : all) {
            climbingrouteDtoList.add(new ClimbingrouteDto(climbingroute));
        }
        return climbingrouteDtoList;
    }

    public void toDTO(Climbingroute climbingroute) {
        this.id = climbingroute.getId();
        this.name = climbingroute.getName();
        this.bonus= climbingroute.getBonus();
        this.latitude = climbingroute.getLatitude();
        this.longitude = climbingroute.getLongitude();
        this.difficulty = climbingroute.getDifficulty();
        this.star = climbingroute.getStar();
        this.physical = climbingroute.getPhysical();
        this.technical = climbingroute.getTechnical();
        this.tactical = climbingroute.getTactical();
        this.mental = climbingroute.getMental();
        this.createdAt = climbingroute.getCreatedAt();
    }
}
