//package com.climbing.zone.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.util.ArrayList;
//
//import java.util.List;
//
//import org.springframework.ui.Model;
//
//@Controller
//public class SpringSessionController {
//
//    @GetMapping("/admin")
//    public String process(Model model, HttpSession session) {
//        @SuppressWarnings("unchecked")
//        List<String> messages = (List<String>) session.getAttribute("MY_SESSION_MESSAGES");
//
//        if (messages == null) {
//            messages = new ArrayList<>();
//        }
//        model.addAttribute("sessionMessages", messages);
//
//        return "/admin/index";
//    }
//
//    @PostMapping("/persistMessage")
//    public String persistMessage(@RequestParam("msg") String msg, HttpServletRequest request) {
//        @SuppressWarnings("unchecked")
//        List<String> messages = (List<String>) request.getSession().getAttribute("MY_SESSION_MESSAGES");
//        if (messages == null) {
//            messages = new ArrayList<>();
//            request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
//        }
//        messages.add(msg);
//        request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
//        return "redirect:/";
//    }
//
//    @PostMapping("/destroy")
//    public String destroySession(HttpServletRequest request) {
//        request.getSession().invalidate();
//        return "redirect:/";
//    }
//}
