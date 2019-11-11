package com.climbing.zone.service;

import com.climbing.zone.domain.Card;
import com.climbing.zone.repository.CardRepository;
import com.climbing.zone.service.dto.CardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

     public List<CardDto> findAll() {
        return CardDto.toDTO(cardRepository.findAll());
    }
//    // add<T>(...)
//    public ResponseEntity<String> add(Card card) {
//        cardRepository.save(card);
//        return new ResponseEntity<>("a brand new card N°" + card.getId() + " has been created", HttpStatus.OK);
//    }
//
//
//
//    // get<T>ById(Long id)
//
//    // update<T>(<t> t)
//    // delete<T>()
//
//
//    public void deleteCardById(Long id) {
//        cardRepository.deleteCardById(id);
//    }
//
//    public List<Card> findCardsByClimbingRouteName(String name) {
//
//        return cardRepository.findCardsByClimbingRouteName(name);
//    }
}
