package com.climbing.zone.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("admin")
public class AdminController {

    //@ApiOperation(value = "index")
//    @RequestMapping(method = RequestMethod.GET, value = "/admin")
//    public String index(){
//        return "admin/index";
//    }
        @GetMapping("index")
        public String index(){
            return "admin/index";
        }

//    //@ApiOperation(value = "login")
//    @RequestMapping(method = RequestMethod.GET, value = "/login")
//    public String login(){
//        return "login";
//    }

}
