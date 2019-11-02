package com.climbing.zone.service;

import com.climbing.zone.domain.Card;
import com.climbing.zone.repository.CardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    // findAll<T>()
    public List<Card> findAll() {
        List<Card> cards = new ArrayList<>();
        cardRepository.findAll().forEach(cards::add);
        return cards;
    }

    // get<T>ById(Long id)
    // add<T>(...)
    public void add(Card card) {
        cardRepository.save(card);
    }
    // update<T>(<t> t)
    // delete<T>()

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
