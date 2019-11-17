package com.climbing.zone.security;

public class JwtProperties {

    public static final String SECRET = "climbingzone";
    public static final int EXPIRATION_TIME = 432_000_000; // 5 jours
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
