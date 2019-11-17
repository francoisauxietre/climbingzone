package com.climbing.zone.service;

import com.climbing.zone.domain.*;
import com.climbing.zone.enumeration.Language;
import com.climbing.zone.repository.CardRepository;
import com.climbing.zone.repository.ClimberRepository;
import com.climbing.zone.repository.ClimbingrouteRepository;
import com.climbing.zone.service.dto.ClimbingrouteDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class ClimbingrouteService {


    @Autowired
    ClimbingrouteRepository climbingrouteRepository;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    ClimberRepository climberRepository;

    //ok
    public List<ClimbingrouteDto> findAll() {

        return ClimbingrouteDto.toDTO(climbingrouteRepository.findAll());
    }

    //ok
    public Climbingroute save(Climbingroute climbingroute) {
        Card card = new Card();
        Climber climber = new Climber();
        climber.setId((long)20); // ici on mettra exactement la seesion quand on sera connecter
        climber.setLastName("toto");
        climber.setFirstName("1");
        Date date = new Date(System.currentTimeMillis());
        climber.setBirth(date);
        climber.setCreatedAt(date);
        climber.setLanguage(Language.ENGLISH);
        CardPk cardPk = new CardPk();
        cardPk.setClimber(climber);
        cardPk.setClimbingroute(climbingroute);
        card.setId(cardPk);
        card.setClimbingRouteName(climbingroute.getClimbingRouteName());
        card.setBonus(climbingroute.getBonus());
        card.setInfo(climbingroute.getInfo());
        card.setDate(climbingroute.getCreatedAt());
        card.setDifficuty(climbingroute.getDifficulty());
        card.setInfo(climbingroute.getInfo());
        card.setTactical(climbingroute.getTactical());
        card.setTechnical(climbingroute.getTechnical());
        card.setPhysical(climbingroute.getPhysical());
        card.setMental(climbingroute.getMental());
        card.setStar(climbingroute.getStar());
        card.setDifficuty(climbingroute.getDifficulty());
        card.setQrcode("qrcode_"+(int)(Math.random()*1000)+".jpg");
        card.setPhoto("photo_"+(int)(Math.random()*1000)+".jpg");
        log.info("cardPk +"+ cardPk.toString());

        //mega bizarre on ne peut sauver la carte que si on a deja sauver le grimpeur et la voie
        climbingrouteRepository.save(climbingroute);
        climberRepository.save(climber);
        cardRepository.save(card);


        return climbingrouteRepository.save(climbingroute);
    }




    public void deleteClimbingrouteById(Long id) {
        climbingrouteRepository.deleteClimbingrouteById(id);
    }


}



