package com.climbing.zone.service;

import com.climbing.zone.domain.Card;
import com.climbing.zone.repository.CardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CardService {

    Logger logger = LoggerFactory.getLogger(Card.class);

    @Autowired
    CardRepository cardRepository;

    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    public Long addCard(int star, String level, String qrcode, String place, String photo, String climbingRouteName, int physical, int technical, int tactical, int mental, String bonus, String climberFirstName, String climberLastName, String info) {
        Card card = new Card();
        card.setStar(star);
        card.setLevel(level);
        card.setQrcode(qrcode);
        card.setPlace(place);
        card.setPhoto(photo);
        card.setClimbingRouteName(climbingRouteName);
        card.setPhysical(physical);
        card.setTechnical(technical);
        card.setTactical(tactical);
        card.setMental(mental);
        card.setBonus(bonus);
        card.setClimberFirstName(climberFirstName);
        card.setClimberLastName(climberLastName);
        card.setInfo(info);
        cardRepository.save(card);
        return card.getId();
    }

    public void deleteCardById(Long id) {
        cardRepository.deleteCardById(id);
    }

    public List<Card> findCardsByClimbingRouteName(String name) {

        return cardRepository.findCardsByClimbingRouteName(name);
    }
}
