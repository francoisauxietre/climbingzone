package com.escalade.demo.service;

import com.escalade.demo.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.escalade.demo.repository.*;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(User.class);

    @Autowired
    UserRepository userRepository;


    public List<User> findAllByName(String name) {
        return userRepository.findAllByName(name);
    }

    public List<User> findAllByFirstName(String firstName) {
        return userRepository.findAllByFirstName(firstName);
    }

    public List<User> findAllByFirstNameAndLastName(String name, String firstName) {
        return userRepository.findAllByNameAndFirstName(name, firstName);
    }

    public List<User> findAllFriendsListByFirstNameAndLastName(String name, String firstName) {
        return userRepository.findAllFriendsListByNameAndFirstName(name, firstName);
    }

    public User findByNameAndFirstName(String name, String firstName) {
        return userRepository.findByNameAndFirstName(name, firstName);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {

        User user =userRepository.findById(id).get();
        return  user;

    }

    public void deleteUserByNameAndFirstName(String name, String firstName) {
        userRepository.deleteUserByNameAndFirstName(name, firstName);
    }


    public void deleteUserByName(String name) {
        userRepository.deleteUserByName(name);
    }


    public void deleteUserById(Long id) {
        userRepository.deleteUserById(id);
    }


    /**
     * methode qui ajoute un utilisateur
     *
     * @param name      :nom
     * @param firstName : prenom
     * @param day       : jour de naissance
     * @param month     :mois
     * @param year      :annee
     * @return l'id du nouvel utilisateur
     */
    public Long addUser(String name, String firstName, int day, int month, int year) {
        User user = new User();
        LocalDate date = LocalDate.of(year, month, day);
        Date birth = Date.valueOf(date);
        user.setBirth(birth);
        user.setName(name);
        user.setFirstName(firstName);
        userRepository.save(user);
        return user.getId();
    }

    /**
     * methode qui ajoute un utilisateur à la liste de ses amis
     * @param user : l'utilisateur courant
     * @param friendName : nom du nouvel ami (s'il est déjà enregristé)
     * @param friendFirstName : prénom
     */
    public void addFriendsList(User user, String friendName, String friendFirstName) {
        User friend = this.findByNameAndFirstName(friendName, friendFirstName);
        if (friend == null)
            logger.warn("cet ami n'existe pas");
        else {
            user.addFriend(friend);
            logger.warn("SUPER !! vous avez " + friend.getName() + " comme nouvel ami");
            userRepository.save(user);
        }
    }


    public List<User> findByAmis() {
        return userRepository.findAll();
    }

}

