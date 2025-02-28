package com.rodrigo.panelAdmin.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.rodrigo.panelAdmin.entities.User;

import java.util.Date;

public class JwtUtil {

    private static final String SECRET_KEY = "gj43jng9";

    public static String generateToken(User user){
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        String token = JWT.create()
                .withIssuer("Rodrigo")
                .withClaim("userId", user.getId())
                .withIssuedAt(new Date())
                .withExpiresAt(getExpiresDate())
                .sign(algorithm);

        return  token;
    }

    private static Date getExpiresDate() {
        return new Date(System.currentTimeMillis()
                + (1000l * 60 * 60 * 24 * 14));
    }
}
