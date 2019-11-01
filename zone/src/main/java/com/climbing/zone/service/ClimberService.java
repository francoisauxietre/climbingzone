package com.climbing.zone.service;

import com.climbing.zone.domain.Climber;
import com.climbing.zone.domain.ClimberClimbingroute;
import com.climbing.zone.domain.Topic;
import com.climbing.zone.repository.ClimberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class ClimberService {
    Logger logger = LoggerFactory.getLogger(Climber.class);
    private List<Topic> topics = Arrays.asList(
            new Topic((long) 1, "test", "java"),
            new Topic((long) 2, "a", "b"),
            new Topic((long) 3, "test", "java2"),
            new Topic((long) 4, "a", "b")
    );

    @Autowired
    ClimberRepository climberRepository;

    public Climber findClimberById(int id) {
        return climberRepository.findClimberById(id);
    }

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



