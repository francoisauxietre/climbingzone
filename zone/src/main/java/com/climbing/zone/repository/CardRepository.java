package com.climbing.zone.repository;

import com.climbing.zone.domain.Card;
import com.climbing.zone.domain.CardPk;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// avec extends on profite des methodes classiques CRUD <class, Id>
public interface CardRepository extends CrudRepository<Card, CardPk> {

//@Query("SELECT t FROM climber t WHERE first_name = :firstName and name = :name")
//    List<Card> findAll();
    //void deleteCardById(Long id);
    //List<Card>findCardsByClimbingRouteName(String climbingRouteName);
    List<Card> findAll();
}
