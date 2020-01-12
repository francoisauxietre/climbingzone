package com.climbing.zone.service;

import com.climbing.zone.domain.*;
import com.climbing.zone.enumeration.BonusType;
import com.climbing.zone.enumeration.Language;
import com.climbing.zone.repository.CardRepository;
import com.climbing.zone.repository.ClimberRepository;
import com.climbing.zone.repository.ClimbingrouteRepository;
import com.climbing.zone.service.dto.ClimbingrouteDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
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

    /**
     * Donne la liste de toutes les voies
     *
     * @return List<ClimbingrouteDto> liste des voies correpondantes
     */
    public List<ClimbingrouteDto> findAll() {

        return ClimbingrouteDto.toDTO(climbingrouteRepository.findAll());
    }

    /**
     * Donne la liste des voies depuis un point gps(latitude et longitude) et un distance
     *
     * @param latitude  latitude du centre de recherche
     * @param longitude longitude du centre de recherche
     * @param distance  distance du point de referende
     * @return List<ClimbingrouteDto> liste des voies correpondantes
     */
    public List<ClimbingrouteDto> findAround(@Param("latitude") float latitude, @Param("longitude") float longitude, @Param("distance") float distance) {

        List<ClimbingrouteDto> routes = new ArrayList<>();
        routes = ClimbingrouteDto.toDTO(climbingrouteRepository.findAround(latitude, longitude, distance));
        return routes;
    }

    /**
     * Donne la liste des voies ayant aumoins X stars
     *
     * @param id nombre d'étoiles /5
     * @return List<ClimbingrouteDto> liste des voies correpondantes
     */
    public List<ClimbingrouteDto> findRouteByStar(@Param("id") int id) {

        List<ClimbingrouteDto> routes = new ArrayList<>();
        routes = ClimbingrouteDto.toDTO(climbingrouteRepository.findRouteByStar(id));
        return routes;
    }

    /**
     * Donne la liste des voies du type ZoneType
     *
     * @param zoneType (EXTERIOR ou INTERRIOR)
     * @return List<ClimbingrouteDto> liste des voies correpondantes
     */
    public List<ClimbingrouteDto> findAllByZoneType(@Param("zoneType") ZoneType zoneType) {
        List<ClimbingrouteDto> routes = new ArrayList<>();
        routes = ClimbingrouteDto.toDTO(climbingrouteRepository.findAllByZoneType(zoneType));
        return routes;
    }

    /**
     * Donne la liste des voies du type route
     *
     * @param routeType (BOULDER ou ROUTE)
     * @return List<ClimbingrouteDto> liste des voies correpondantes
     */
    public List<ClimbingrouteDto> findAllByRouteType(@Param("routeType") RouteType routeType) {
        List<ClimbingrouteDto> routes = new ArrayList<>();
        routes = ClimbingrouteDto.toDTO(climbingrouteRepository.findAllByRouteType(routeType));
        return routes;
    }

    /**
     * Donne la liste des voies ayant cette difficulté
     *
     * @param id la difficulté demandé
     * @return List<ClimbingrouteDto> liste des voies correpondantes
     */
    public List<ClimbingrouteDto> findAllByDifficulty(@Param("id") Integer id) {
        List<ClimbingrouteDto> routes = new ArrayList<>();
        routes = ClimbingrouteDto.toDTO(climbingrouteRepository.findAllByDifficulty(id));
        return routes;
    }

    /**
     * Donne la liste des voies ayant au moins cette difficulté
     *
     * @param id la difficulté demandé
     * @return List<ClimbingrouteDto> liste des voies correpondantes
     */
    public List<ClimbingrouteDto> findAllByDifficultyMin(@Param("id") Integer id) {
        List<ClimbingrouteDto> routes = new ArrayList<>();
        routes = ClimbingrouteDto.toDTO(climbingrouteRepository.findAllByDifficultyMin(id));
        return routes;
    }

    /**
     * Donne la liste des voies ayant au plus cette difficulté
     *
     * @param id la difficulté demandé
     * @return List<ClimbingrouteDto> liste des voies correpondantes
     */
    public List<ClimbingrouteDto> findAllByDifficultyMax(@Param("id") Integer id) {
        List<ClimbingrouteDto> routes = new ArrayList<>();
        routes = ClimbingrouteDto.toDTO(climbingrouteRepository.findAllByDifficultyMax(id));
        return routes;
    }

    /**
     * Donne la liste des voies par type de bonus
     *
     * @param bonusType
     * @return List<ClimbingrouteDto> liste des voies correpondantes
     */
    public List<ClimbingrouteDto> findAllByBonus(@Param("bonusType") BonusType bonusType) {
        List<ClimbingrouteDto> routes = new ArrayList<>();
        routes = ClimbingrouteDto.toDTO(climbingrouteRepository.findAllByBonus(bonusType));
        return routes;
    }
//physique

    /**
     * Donne la liste des voies ayant cette difficulté physique
     *
     * @param id la difficulté demandé
     * @return List<ClimbingrouteDto> liste des voies correpondantes
     */
    public List<ClimbingrouteDto> findAllByPhysical(@Param("id") Integer id) {
        List<ClimbingrouteDto> routes = new ArrayList<>();
        routes = ClimbingrouteDto.toDTO(climbingrouteRepository.findAllByPhysical(id));
        return routes;
    }

    /**
     * Donne la liste des voies ayant au moins cette difficulté physique
     *
     * @param id la difficulté demandé
     * @return List<ClimbingrouteDto> liste des voies correpondantes
     */
    public List<ClimbingrouteDto> findAllByPhysicalMin(@Param("id") Integer id) {
        List<ClimbingrouteDto> routes = new ArrayList<>();
        routes = ClimbingrouteDto.toDTO(climbingrouteRepository.findAllByPhysicalMin(id));
        return routes;
    }

    /**
     * Donne la liste des voies ayant au plus cette difficulté physique
     *
     * @param id la difficulté demandé
     * @return List<ClimbingrouteDto> liste des voies correpondantes
     */
    public List<ClimbingrouteDto> findAllByPhysicalMax(@Param("id") Integer id) {
        List<ClimbingrouteDto> routes = new ArrayList<>();
        routes = ClimbingrouteDto.toDTO(climbingrouteRepository.findAllByPhysicalMax(id));
        return routes;
    }

    //technique

    /**
     * Donne la liste des voies ayant cette difficulté technique
     *
     * @param id la difficulté demandé
     * @return List<ClimbingrouteDto> liste des voies correpondantes
     */
    public List<ClimbingrouteDto> findAllByTechnical(@Param("id") Integer id) {
        List<ClimbingrouteDto> routes = new ArrayList<>();
        routes = ClimbingrouteDto.toDTO(climbingrouteRepository.findAllByTechnical(id));
        return routes;
    }

    /**
     * Donne la liste des voies ayant au moins cette difficulté technique
     *
     * @param id la difficulté demandé
     * @return List<ClimbingrouteDto> liste des voies correpondantes
     */
    public List<ClimbingrouteDto> findAllByTechnicalMin(@Param("id") Integer id) {
        List<ClimbingrouteDto> routes = new ArrayList<>();
        routes = ClimbingrouteDto.toDTO(climbingrouteRepository.findAllByTechnicalMin(id));
        return routes;
    }

    /**
     * Donne la liste des voies ayant au plus cette difficulté technique
     *
     * @param id la difficulté demandé
     * @return List<ClimbingrouteDto> liste des voies correpondantes
     */
    public List<ClimbingrouteDto> findAllByTechnicalMax(@Param("id") Integer id) {
        List<ClimbingrouteDto> routes = new ArrayList<>();
        routes = ClimbingrouteDto.toDTO(climbingrouteRepository.findAllByTechnicalMax(id));
        return routes;
    }

    //tactique

    /**
     * Donne la liste des voies ayant cette difficulté tactique
     *
     * @param id la tactique demandé
     * @return List<ClimbingrouteDto> liste des voies correpondantes
     */
    public List<ClimbingrouteDto> findAllByTactical(@Param("id") Integer id) {
        List<ClimbingrouteDto> routes = new ArrayList<>();
        routes = ClimbingrouteDto.toDTO(climbingrouteRepository.findAllByTactical(id));
        return routes;
    }

    /**
     * Donne la liste des voies ayant au moins cette difficulté technique
     *
     * @param id la difficulté demandé
     * @return List<ClimbingrouteDto> liste des voies correpondantes
     */
    public List<ClimbingrouteDto> findAllByTacticalMin(@Param("id") Integer id) {
        List<ClimbingrouteDto> routes = new ArrayList<>();
        routes = ClimbingrouteDto.toDTO(climbingrouteRepository.findAllByTacticalMin(id));
        return routes;
    }

    /**
     * Donne la liste des voies ayant au plus cette difficulté technique
     *
     * @param id la difficulté demandé
     * @return List<ClimbingrouteDto> liste des voies correpondantes
     */
    public List<ClimbingrouteDto> findAllByTacticalMax(@Param("id") Integer id) {
        List<ClimbingrouteDto> routes = new ArrayList<>();
        routes = ClimbingrouteDto.toDTO(climbingrouteRepository.findAllByTacticalMax(id));
        return routes;
    }

    //mental

    /**
     * Donne la liste des voies ayant cette difficulté mental
     *
     * @param id le mental demandé
     * @return List<ClimbingrouteDto> liste des voies correpondantes
     */
    public List<ClimbingrouteDto> findAllByMental(@Param("id") Integer id) {
        List<ClimbingrouteDto> routes = new ArrayList<>();
        routes = ClimbingrouteDto.toDTO(climbingrouteRepository.findAllByMental(id));
        return routes;
    }

    /**
     * Donne la liste des voies ayant au moins cette difficulté mental
     *
     * @param id le mental demandé
     * @return List<ClimbingrouteDto> liste des voies correpondantes
     */
    public List<ClimbingrouteDto> findAllByMentalMin(@Param("id") Integer id) {
        List<ClimbingrouteDto> routes = new ArrayList<>();
        routes = ClimbingrouteDto.toDTO(climbingrouteRepository.findAllByMentalMin(id));
        return routes;
    }

    /**
     * Donne la liste des voies ayant au plus cette difficulté mental
     *
     * @param id le mental demandé
     * @return List<ClimbingrouteDto> liste des voies correpondantes
     */
    public List<ClimbingrouteDto> findAllByMentalMax(@Param("id") Integer id) {
        List<ClimbingrouteDto> routes = new ArrayList<>();
        routes = ClimbingrouteDto.toDTO(climbingrouteRepository.findAllByMentalMax(id));
        return routes;
    }

    /**
     * Sauvegarde de notre voie ces parametres seront envoyés par nos clients  (React, vuejs, angular et l'application AndroidClimbing)
     *
     * @param climbingroute
     * @return un voie
     */
    //TODO A completer avec les envois des données
    public Climbingroute save(Climbingroute climbingroute) {
        Card card = new Card();
        Climber climber = new Climber();
        climber.setId((long) 20); // ici on mettra exactement la seesion quand on sera connecter
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
        card.setDifficuty("" + climbingroute.getDifficulty());
        card.setInfo(climbingroute.getInfo());
        card.setTactical(climbingroute.getTactical());
        card.setTechnical(climbingroute.getTechnical());
        card.setPhysical(climbingroute.getPhysical());
        card.setMental(climbingroute.getMental());
        card.setStar(climbingroute.getStar());
        card.setDifficuty("" + climbingroute.getDifficulty());
        card.setQrcode("qrcode_" + (int) (Math.random() * 1000) + ".jpg");
        card.setPhoto("photo_" + (int) (Math.random() * 1000) + ".jpg");
        log.info("cardPk +" + cardPk.toString());

        //mega bizarre on ne peut sauver la carte que si on a deja sauver le grimpeur et la voie
        climbingrouteRepository.save(climbingroute);
        climberRepository.save(climber);
        cardRepository.save(card);

        return climbingrouteRepository.save(climbingroute);
    }

    /**
     * fonction uniquement pour l'administrateur en cas de problème
     *
     * @param id id de l'utilisateur à effacer
     */
    public void deleteClimbingrouteById(Long id) {
        climbingrouteRepository.deleteClimbingrouteById(id);
    }
}



