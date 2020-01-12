package com.climbing.zone.repository;

import com.climbing.zone.domain.*;
import com.climbing.zone.enumeration.BonusType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

//sert a dialoguer avec la base de donnee

public interface ClimbingrouteRepository extends CrudRepository<Climbingroute, Long> {

    List<Climbingroute> findAll();
    void deleteClimbingrouteById(Long id);

    @Query("select c from Climbingroute c where c.latitude > (:latitude - :distance) and c.latitude < (:latitude + :distance) and c.longitude > (:longitude - :distance) and c.longitude < (:longitude + :distance) ")
    List<Climbingroute> findAround(@Param("latitude") float latitude,
                                   @Param("longitude") float longitude,
                                   @Param("distance") float distance);

    @Query("select c from Climbingroute c where c.star >= (:id)")
    List<Climbingroute> findRouteByStar(@Param("id") int id);

    @Query("select c from Climbingroute c where c.zoneType = (:zoneType)")
    List<Climbingroute> findAllByZoneType(@Param("zoneType") ZoneType zoneType);

    @Query("select c from Climbingroute c where c.routeType = (:routeType)")
    List<Climbingroute> findAllByRouteType(@Param("routeType") RouteType routeType);

    @Query("select c from Climbingroute c where c.difficulty = (:id)")
    List<Climbingroute> findAllByDifficulty(@Param("id") Integer id);

    @Query("select c from Climbingroute c where c.difficulty >= (:id)")
    List<Climbingroute> findAllByDifficultyMin(@Param("id") Integer id);

    @Query("select c from Climbingroute c where c.difficulty <= (:id)")
    List<Climbingroute> findAllByDifficultyMax(@Param("id") Integer id);

    @Query("select c from Climbingroute c where c.bonus = (:bonusType)")
    List<Climbingroute> findAllByBonus(@Param("bonusType") BonusType bonusType);

    //physique
    @Query("select c from Climbingroute c where c.physical = (:id)")
    List<Climbingroute> findAllByPhysical(@Param("id") Integer id);

    @Query("select c from Climbingroute c where c.physical >= (:id)")
    List<Climbingroute> findAllByPhysicalMin(@Param("id") Integer id);

    @Query("select c from Climbingroute c where c.physical <= (:id)")
    List<Climbingroute> findAllByPhysicalMax(@Param("id") Integer id);

    //technique
    @Query("select c from Climbingroute c where c.technical = (:id)")
    List<Climbingroute> findAllByTechnical(@Param("id") Integer id);

    @Query("select c from Climbingroute c where c.technical >= (:id)")
    List<Climbingroute> findAllByTechnicalMin(@Param("id") Integer id);

    @Query("select c from Climbingroute c where c.technical <= (:id)")
    List<Climbingroute> findAllByTechnicalMax(@Param("id") Integer id);

   //mental
   @Query("select c from Climbingroute c where c.mental = (:id)")
   List<Climbingroute> findAllByMental(@Param("id") Integer id);

    @Query("select c from Climbingroute c where c.mental >= (:id)")
    List<Climbingroute> findAllByMentalMin(@Param("id") Integer id);

    @Query("select c from Climbingroute c where c.mental <= (:id)")
    List<Climbingroute> findAllByMentalMax(@Param("id") Integer id);

    //tactique
    @Query("select c from Climbingroute c where c.tactical = (:id)")
    List<Climbingroute> findAllByTactical(@Param("id") Integer id);

    @Query("select c from Climbingroute c where c.tactical >= (:id)")
    List<Climbingroute> findAllByTacticalMin(@Param("id") Integer id);

    @Query("select c from Climbingroute c where c.tactical <= (:id)")
    List<Climbingroute> findAllByTacticalMax(@Param("id") Integer id);




}

//    @Async
//    Future<Todo> findById(Long id);
//@Query("select latitude from Climbingroute c where c.latitude >1")