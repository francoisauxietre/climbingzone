package com.climbing.zone;

import com.climbing.zone.domain.Card;
import com.climbing.zone.domain.CardPk;
import com.climbing.zone.domain.Climber;
import com.climbing.zone.domain.Climbingroute;
import com.climbing.zone.repository.CardRepository;
import com.climbing.zone.repository.ClimberRepository;
import com.climbing.zone.repository.ClimbingrouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

// modification pour le docker de public class ZoneApplication extends SpringBootServletInitializer
@SpringBootApplication
public class ZoneApplication {

    @Autowired
    private ClimbingrouteRepository climbingrouteRepository;
    @Autowired
    private ClimberRepository climberRepository;
    @Autowired
    private CardRepository cardRepository;
    private int nombre;

    //
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(ZoneApplication.class);
//	}
    public static void main(String[] args) {
        SpringApplication.run(ZoneApplication.class, args);
    }

    @PostConstruct
    public void init() {

        Set<Climber> climbers = new HashSet<>();
        Set<Climbingroute> climbingroutes = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            this.nombre = (int) (Math.random() * 100);
            System.out.println(nombre);
            Climber climber = new Climber();
            climber.setLastName("aux" + (int) (Math.random() * 10000));
            climber.setFirstName("fa" + this.nombre);
            Date date = new Date(System.currentTimeMillis());
            climber.setBirth(date);
            Climbingroute climbingroute = new Climbingroute();
            climbingroute.setName("cl" + (int) (Math.random() * 100));

            climbers.add(climber);
            climbingroutes.add(climbingroute);
            climberRepository.save(climber);
            climbingrouteRepository.save(climbingroute);
            Card card = new Card();
            CardPk cardPk = new CardPk();
            cardPk.setClimber(climber);
            cardPk.setClimbingroute(climbingroute);
            card.setId(cardPk);
            card.setBonus("Jeté");
            card.setTactical((int) (Math.random() * 5));
            card.setTechnical((int) (Math.random() * 5));
            card.setPhysical((int) (Math.random() * 5));
            card.setMental((int) (Math.random() * 5));

            cardRepository.save(card);
        }

//
//        System.out.println(climberList.size());
//        System.out.println(climbingrouteList.size());
//
//        System.out.println("===================Students info:==================");
//        climberList.forEach(student -> System.out.println(student.toString()));
//
//        System.out.println("===================Students info:==================");

    }
}
