package com.climbing.zone.configuration;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class DynamicInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        log.info("methode  appelante: {}", method.getName());

        return 42;
    }
}