package com.climbing.zone.service;

import com.climbing.zone.domain.Climber;
import com.climbing.zone.repository.ClimberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClimberService {

        Logger logger = LoggerFactory.getLogger(Climber.class);

        @Autowired
        ClimberRepository climberRepository;


        public List<Climber> findAllByLastName(String lastName) {
            return climberRepository.findByLastName(lastName);
        }

        public List<Climber> findAll(){
                return climberRepository.findAll();
        }
}


