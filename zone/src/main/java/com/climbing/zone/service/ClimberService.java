package com.climbing.zone.service;

import com.climbing.zone.domain.Climber;
import com.climbing.zone.domain.ClimberClimbingroute;
import com.climbing.zone.repository.ClimberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class ClimberService {

    Logger logger = LoggerFactory.getLogger(Climber.class);

    @Autowired
    ClimberRepository climberRepository;

    /**
     * @return 1
     * TODO voir avec le session du grimpeur
     */
    public Climber findClimberByIdClimber(Long idClimber) {
       return climberRepository.findClimberByIdClimber(idClimber);
    }


    public void addClimbingroute(long idRoute){


    }
    /**
     * liste de tous les grimpeurs
     *
     * @return liste des grimpeurs enregistrés
     */
    public List<Climber> findAll() {
        return climberRepository.findAll();
    }

    /**
     * @param lastName  :nom
     * @param firstName :prenom
     * @param day       : jour de naissance
     * @param month     :mois
     * @param year      :annee
     * @return l'id du nouvel utilisateur
     */
    public Long addClimber(String lastName, String firstName, int day, int month, int year) {
        Climber climber = new Climber();
        LocalDate date = LocalDate.of(year, month, day);
        Date birth = Date.valueOf(date);
        climber.setBirth(birth);
        climber.setLastName(lastName);
        climber.setFirstName(firstName);
        climberRepository.save(climber);
        return climber.getIdClimber();
    }

//    public void addClimbingroute(Long idClimbingroute) {
//        Long idClimber = findId();
//        ClimberClimbingroute climberClimbingroute = new ClimberClimbingroute(idClimber, idClimbingroute);
//        climberClimbingroute.setIdClimber(idClimber);
//        climberClimbingroute.setIdClimberClimbingroute(idClimbingroute);
//        climberRepository.addClimbingroute(idClimbingroute);
//    }

    /**
     * Admin : efface un grimpeiur depuis son id
     *
     * @param idClimber : id du grimpeur
     */
    public void deleteClimberByIdClimber(Long idClimber) {
        climberRepository.deleteClimberByIdClimber(idClimber);

    }


    /**
     * affiche la liste des grimpeurs par prénom
     *
     * @param lastName
     * @return
     */
    public List<Climber> findAllByLastName(String lastName) {
        return climberRepository.findByLastName(lastName);
    }

    /**
     * affiche la liste des grimpeurs par nom
     *
     * @param firstName
     * @return
     */
    public List<Climber> findAllByFirstName(String firstName) {
        return climberRepository.findByFirstName(firstName);
    }


}



