package com.climbing.zone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("management")
public class ManagerController {

    //@ApiOperation(value = "index")
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() {
        return "management/index";
    }
}
