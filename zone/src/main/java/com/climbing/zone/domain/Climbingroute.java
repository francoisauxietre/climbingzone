package com.climbing.zone.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "climbing_route")
@Data
public class Climbingroute implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "climbing_route_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "bonus")
    private String bonus;

    @Column(name = "latitude")
    private Float latitude;

    @Column(name = "longitude")
    private Float longitude;

    @Column(name = "difficuty")
    private String difficuty;

    @Column(name = "star")
    private Integer star;

    @Column(name = "physical_avg")
    private Integer physical;

    @Column(name = "technical")
    private Integer technical;

    @Column(name = "tactical")
    private Integer tactical;

    @Column(name = "mental")
    private Integer mental;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "modified_at")
    private Instant modifiedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "route_type")
    private RouteType routeType;

    @Enumerated(EnumType.STRING)
    @Column(name = "zone_type")
    private ZoneType zoneType;

    @OneToMany(mappedBy = "located")
    private Set<Place> places = new HashSet<>();

    @OneToMany(mappedBy = "openBy")
    private Set<Climber> openers = new HashSet<>();

    @OneToMany(mappedBy = "id.climber")//, cascade = CascadeType.ALL
    @JsonManagedReference
    private Set<Card> cards = new HashSet<>();
}