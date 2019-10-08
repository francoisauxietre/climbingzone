package com.climbing.zone.repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

//recree une datebase
@Component
@ConditionalOnProperty(name = "climbing.db.recreate", havingValue = "true")
public class dataBase implements CommandLineRunner {

    private ClimberRepository climberRepository;

    public dataBase(ClimberRepository climberRepository) {

        this.climberRepository = climberRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        this.climberRepository.deleteAll();
    }
}

