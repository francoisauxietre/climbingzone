package com.climbing.zone.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(value = "Logger", tags = {"Operation for logger"})
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class LoggerController {

    @Autowired
    private Logger logger;

    @GetMapping("/log")
    public ResponseEntity<String> log() {
        logger.trace("Logger trace message :");
        logger.debug("Logger debug message");
        logger.info("Logger info message");
        logger.warn("Logger warning");
        logger.error("Logger errors message");

        return new ResponseEntity<>("Problems founded on this url, please look logs infos", HttpStatus.OK);
    }
}