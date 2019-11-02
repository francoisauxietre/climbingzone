package com.climbing.zone.service.dto;

import lombok.*;

import java.io.Serializable;
import java.io.Serializable;
@NoArgsConstructor //génère le constructeur sans argument et public ;
@AllArgsConstructor //génère le constructeur avec tous les arguments
@Getter //génère tous les getters sur les champs ;
@Setter //génère tous les setters sur les champs ;
@EqualsAndHashCode(of = {"id", "name"})
public class CountryDto implements Serializable {
    private Long id;
    private String name;
    private Long climbersId;}

