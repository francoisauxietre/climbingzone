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
import java.util.HashSet;
import java.util.Set;

// modification pour le docker de public class ZoneApplication extends SpringBootServletInitializer
@SpringBootApplication
public class ZoneApplication {

	@Autowired private ClimbingrouteRepository climbingrouteRepository;
	@Autowired private ClimberRepository climberRepository;
	@Autowired private CardRepository cardRepository;
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(ZoneApplication.class);
//	}
	public static void main(String[] args) {
		SpringApplication.run(ZoneApplication.class, args);
	}

	@PostConstruct
	public void init(){


		Climber fa = new Climber();
		fa.setFirstName("fa");
		Climber fa1 = new Climber();
		fa1.setFirstName("fa1");

		Climbingroute climbingroute = new Climbingroute();
		climbingroute.setName("cl");
		Climbingroute climbingroute1 = new Climbingroute();
		climbingroute.setName("cl1");

		Set<Climber> climbers = new HashSet<>();
		climbers.add(fa);
		climbers.add(fa1);

		Set<Climbingroute> climbingroutes = new HashSet<>();
		climbingroutes.add(climbingroute);
		climbingroutes.add(climbingroute1);

		climberRepository.save(fa);
		climberRepository.save(fa1);
		climbingrouteRepository.save(climbingroute);
		climbingrouteRepository.save(climbingroute1);

		Card card = new Card();
		CardPk id = new CardPk();
		id.setClimber(fa);
		id.setClimbingroute(climbingroute);
		card.setId(id);
		cardRepository.save(card);

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
