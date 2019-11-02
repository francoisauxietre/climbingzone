package com.climbing.zone.service.dto;

import com.climbing.zone.enumeration.RouteType;
import com.climbing.zone.enumeration.ZoneType;

import java.io.Serializable;
import java.time.Instant;

public class ClimbingrouteDto  implements Serializable {

    private Long id;
    private String name;
    private String bonus;
    private Float latitude;
    private Float longitude;
    private String difficuty;
    private Integer star;
    private Integer physical;
    private Integer technical;
    private Integer tactical;
    private Integer mental;
    private Instant createdAt;
    private Instant modifiedAt;
    private Instant deletedAt;
    private RouteType routeType;
    private ZoneType zoneType;
}