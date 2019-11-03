package com.climbing.zone.service.mapper;

import java.util.List;

// contrat entre les dto et Entity
// normalement on ne met qu'une seule lettre pour la genericite
//mais pour mieux comprendre j'ai preferer 3 lettres

public interface EntityMapper<Ent, Dto> {
    Ent toEntity(Dto dto);
    Dto toDto(Ent entity);
    List<Ent> toEntity(List<Dto> dtoList);
    List<Dto> toDto(List<Ent> entityList);
}
