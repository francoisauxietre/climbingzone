package com.climbing.zone.repository;

import com.climbing.zone.domain.Climber;
import com.climbing.zone.domain.ClimberClimbingroute;
import com.climbing.zone.domain.Climbingroute;
import org.jboss.logging.annotations.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.nio.channels.SelectableChannel;
import java.util.List;

public interface ClimberClimbingrouteRepository extends CrudRepository<ClimberClimbingroute, Long> {
    List<ClimberClimbingroute> findAllByClimber (Climber climber);

//    int ClimbingrouteClimbersCount(String idClimbingroute);
//    int ClimbingrouteClimberOrder(Long idClimbingroute, Long idClimber);
}
