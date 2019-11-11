package com.climbing.zone.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
public class CardPk implements Serializable {

    @ManyToOne
    @JsonBackReference
    private Climber climber;

    @ManyToOne
    @JsonBackReference
    private Climbingroute climbingroute;

}
