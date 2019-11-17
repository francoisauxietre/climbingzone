package com.climbing.zone.controller;

import com.climbing.zone.domain.User;
import com.climbing.zone.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/public")
@CrossOrigin
public class PublicController {
    @Autowired
    private UserRepository userRepository;

    public PublicController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("test")
    public String test(){ return "API TEST";}

    @GetMapping("manager/reports")
    public String getReports(){ return "reports";}

    @GetMapping("admin/users")
    public List<User> getUsers(){ return this.userRepository.findAll();}



}
