package com.climbing.zone.service;

import com.climbing.zone.domain.Climber;
import com.climbing.zone.domain.Topic;
//import com.climbing.zone.domain.User;
import com.climbing.zone.repository.ClimberRepository;
import com.climbing.zone.service.dto.ClimberDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Date;

@Service
public class ClimberService {
    @Autowired
    Logger logger;
//    Logger logger = LoggerFactory.getLogger(Climber.class);

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic((long) 1, "test", "java"),
            new Topic((long) 2, "a", "b"),
            new Topic((long) 3, "test", "java2"),
            new Topic((long) 4, "a", "b"))
    );

    @Autowired
    ClimberRepository climberRepository;

//-----------------------------------------TOPICS---------------------------------------------------------------

    public List<Topic> getAllTopic() {
        return topics;
    }

    public Topic getFirstTopic(Long id) {
        return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
    }

    public Topic getFirstTopicByName(String name) {
        return topics.stream().filter(topic -> topic.getName().equals(name)).findFirst().get();
    }

    public Topic getFirstTopicByInfo(String info) {
        return topics.stream().filter(topic -> topic.getInfo().equals(info)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

//-----------------------------------------CLIMBER---------------------------------------------------------------

    public List<ClimberDto> findAll() {
        return ClimberDto.toDTO(climberRepository.findAll());
    }

    public Climber save(Climber climber) {
        return climberRepository.save(climber);
    }

    public Climber addClimber(String firstName, String lastName, Date birth, String info) {

        Climber climber = new Climber();
        climber.setFirstName(firstName);
        climber.setLastName(lastName);
        climber.setBirth(birth);

        climberRepository.save(climber);
        return climber;
    }

//    public List<Climber> findClimbersByFirstName(String firstName) {
//        return climberRepository.findClimbersByFirstName(firstName);
//    }

//
//    public List<Climber> findClimbersByLastName(String lastName) {
//        return climberRepository.findClimbersByLastName(lastName);
//    }
//
//    public void update(String firstName, String lastName, int day, int month, int year, String info) {
//        update(firstName, lastName, day, month, year, info);
//    }
//
//    public void delete(int value) {
//        climberRepository.deleteById((long) value);
//    }

//    public Page<Climber> findAll(Pageable pageable) {
//        return null;
//    }

//
//    public Climber findClimberByIdClimber(Long idClimber) {
//        return climberRepository.findClimberByIdClimber(idClimber);
//    }
//
//    public void addClimbingroute(long idRoute) {
//    }
//
//    public List<Climber> findAll() {
//        return climberRepository.findAll();
//    }
//
//
//    public String addClimber(String firstName, String lastName, int day, int month, int year) {
//        Climber climber = new Climber();
//        LocalDate date = LocalDate.of(year, month, day);
//        Date birth = Date.valueOf(date);
//        climber.setLastName(lastName);
//        climber.setFirstName(firstName);
//        System.out.println(' ' + firstName + lastName + day + month + year + birth);
//        climberRepository.save(climber);
//        return climber.getFirstName();
//    }
//
//    public void deleteClimberByIdClimber(Long idClimber) {
//        climberRepository.deleteClimberByIdClimber(idClimber);
//    }
//
//    public List<Climber> findAllByLastName(String lastName) {
//        return climberRepository.findByLastName(lastName);
//    }
//
//    public List<Climber> findAllByFirstName(String firstName) {
//        return climberRepository.findByFirstName(firstName);
//    }
//
}



