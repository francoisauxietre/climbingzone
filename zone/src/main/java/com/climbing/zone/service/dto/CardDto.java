package com.climbing.zone.service.dto;

import com.climbing.zone.domain.Card;
import com.climbing.zone.domain.CardPk;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// lombox

//@FieldDefaults(level=AccessLevel.PRIVATE) //: passe tous les champs en private ;
@Data
@NoArgsConstructor //génère le constructeur sans argument et public ;
@AllArgsConstructor //génère le constructeur avec tous les arguments
@Getter //génère tous les getters sur les champs ;
@Setter //génère tous les setters sur les champs ;
@EqualsAndHashCode(of = {"id", "cardId", "climberFirstName", "climberLastName"})
// génère equals et hashCode (et d'autres méthodes) sur les champs donnés ;
public class CardDto implements Serializable {

    private CardPk id;
    private Integer star;
    private String info;
    private String difficulty;
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

    public CardDto(Card card) {
        toDTO(card);
    }


    public static List<CardDto> toDTO(Iterable<Card> all) {
        List<CardDto> cardDtoList = new ArrayList<>();
        for (Card card : all) {
            cardDtoList.add(new CardDto(card));
        }
        return cardDtoList;
    }

    //TODO  voir tous les champs necessaire pour faire une carte entiere
    public void toDTO(Card card) {
        this.id = card.getId();
        this.star = card.getStar();
        this.info = card.getInfo();
        this.difficulty = card.getDifficuty();
        this.qrcode= card.getQrcode();
        this.bonus = card.getBonus();
        this.mental = card.getMental();
        this.technical = card.getTechnical();
        this.tactical = card.getTactical();
        this.physical = card.getPhysical();
        this.climbingRouteName = card.getClimbingRouteName();

    }
}