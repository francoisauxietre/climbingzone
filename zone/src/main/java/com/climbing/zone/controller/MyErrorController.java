//package com.climbing.zone.controller;
//
//import com.climbing.zone.domain.Climber;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.http.HttpServletRequest;
//
//@Controller
//public class MyErrorController implements ErrorController {
//
//    Logger logger = LoggerFactory.getLogger(Climber.class);
//
//    @Override
//    public String getErrorPath() {
//        return "/error";
//    }
//
//    @RequestMapping("/error")
//    public String handleError(HttpServletRequest request) {
//        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//
//        if (status != null) {
//            Integer statusCode = Integer.valueOf(status.toString());
//
//            if (statusCode == HttpStatus.NOT_FOUND.value()) {
//                logger.info("erreur sur l'url "+request.toString());
//                System.out.println("erreur sur url trouvee");
//                return "error";
//            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
//                logger.info("erreur sur l'url "+request.toString());
//                System.out.println("erreur sur url trouvee");
//                return "error";
//            }
//        }
//        return "error";
//    }
//}