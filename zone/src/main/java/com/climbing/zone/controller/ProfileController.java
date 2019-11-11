package com.climbing.zone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("profile")
public class ProfileController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index(){
        return "profile/index";
    }


}
