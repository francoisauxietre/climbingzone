package com.climbing.zone.service;

import com.climbing.zone.domain.Card;
import com.climbing.zone.domain.Climber;
import com.climbing.zone.repository.CardRepository;
import com.climbing.zone.repository.ClimberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class CardService {

    Logger logger = LoggerFactory.getLogger(Card.class);

    @Autowired
    CardRepository cardRepository;


    /**
     * liste de tous les cartes
     * @return liste des cartes enregistrées
     */
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    public Long addCard(String name, int physique, int technique, int tactique, int mental) {
        Card card = new Card();

        card.setName(name);
        card.setPhysique(physique);
        card.setTechnique(technique);
        card.setTactique(tactique);
        card.setMental(mental);
        cardRepository.save(card);
        return card.getIdCard();
    }

    /**
     * Admin : efface une carte depuis son id
     * @param idCard : id de la carte
     */
    public void deleteCardByIdCard(Long idCard) {
        cardRepository.deleteCardByIdCard(idCard);
    }

    public List<Card>findCardsByName(String name){

       return cardRepository.findCardsByName(name);
    }

}
