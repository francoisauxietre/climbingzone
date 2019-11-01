package com.climbing.zone.repository;

import com.climbing.zone.domain.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CardRepository extends CrudRepository<Card, Long> {
    List<Card> findAll();
    void deleteCardById(Long id);
    List<Card>findCardsByClimbingRouteName(String climbingRouteName);
}
