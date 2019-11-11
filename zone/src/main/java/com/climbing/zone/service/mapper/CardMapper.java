//package com.climbing.zone.service.mapper;
//
//import com.climbing.zone.domain.Card;
//import com.climbing.zone.service.dto.CardDto;
////import com.climbingzone5.domain.*;
////import com.climbingzone5.service.dto.CardDTO;
//
////import org.mapstruct.*;
//
////@Mapper(componentModel = "spring", uses = {})
//public interface CardMapper extends  EntityMapper<CardDto, Card> {
//
////    @Mapping(target = "climbers", ignore = true)
////    @Mapping(target = "removeClimber", ignore = true)
////    Card toEntity(CardDTO cardDTO);
//
//    default Card fromId(Long id) {
//        if (id == null) {
//            return null;
//        }
//        Card card = new Card();
//        card.setId(id);
//        return card;
//    }
//}
