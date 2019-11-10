package com.climbing.zone.controller;

import com.climbing.zone.service.UserService;

import com.climbing.zone.service.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController(value = "/users")
@CrossOrigin(origins = "http://localhost:4200")
@Api(value = "User", tags = {"Api Users"})
@RequestMapping("/users")
public class UserController {

    @Autowired
    Logger logger;

    @Autowired
    UserService userService;

    //-----------------------------------------User---------------------------------------------------------------

    //get
    @ApiOperation(value = "User DTO")
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResponseEntity<List<UserDto>> findAll() {
        logger.info("liste des cartes demandee");
        return new ResponseEntity<List<UserDto>>(userService.findAll(), HttpStatus.OK);
    }
}

//
//    @GetMapping("/signup")
//    public String showSignUpForm(User user) {
//        return "add-user";
//    }
//
//    @PostMapping("/adduser")
//    public String addUser(@Valid User user, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "add-user";
//        }
//
//        userRepository.save(user);
//        model.addAttribute("users", userRepository.findAll());
//        return "index";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String showUpdateForm(@PathVariable("id") long id, Model model) {
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
//
//        model.addAttribute("user", user);
//        return "update-user";
//    }
//
//    @PostMapping("/update/{id}")
//    public String updateUser(@PathVariable("id") long id, @Valid User user,
//                             BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            user.setId(id);
//            return "update-user";
//        }
//
//        userRepository.save(user);
//        model.addAttribute("users", userRepository.findAll());
//        return "index";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteUser(@PathVariable("id") long id, Model model) {
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
//        userRepository.delete(user);
//        model.addAttribute("users", userRepository.findAll());
//        return "index";
//    }
//
//}
