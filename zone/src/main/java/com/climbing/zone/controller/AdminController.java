package com.climbing.zone.controller;

import com.climbing.zone.configuration.DynamicInvocationHandler;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("admin")
public class AdminController {

    @GetMapping("index")
    public String index() {
        log.info("rentre dans AdminController");
        //test du proxy
        map.put("hello", "world");
        map.get("hello");
        return "admin/index";
    }

    //    Map map = (Map) Proxy.newProxyInstance(
//            AdminController.class.getClassLoader(),
//            new Class[] { Map.class },
//            new DynamicInvocationHandler());
    Map map = (Map) Proxy.newProxyInstance(
            AdminController.class.getClassLoader(),
            new Class[]{Map.class},
            (proxy, method, methodArgs) -> {
                if (method.getName().equals("get")) {
                    return 42;
                } else {
                    log.info("methode " + method.getName() +" non supportee ici !");
                    // throw new UnsupportedOperationException(
                }
                return proxy;
            });
}

