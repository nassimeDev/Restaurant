package dev.nassime.restaurant1.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTService {

    @Value("${jwt.algorithm.key}")
    private String algorithmKey;
    @Value("${jwt.issure}")
    private String issure;
    @Value("${jwt.expiry.seconds}")
    private long ExpiryInSeconds;

    private Algorithm algorithm;

    private static final String USERNAME_KEY = "username";

    @PostConstruct
    public void postConstructor(){
        algorithm = Algorithm.HMAC256(issure);
    }

    public String generateToken(String username) {
        return JWT.create()
                .withClaim(USERNAME_KEY, username)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000*ExpiryInSeconds))
                .withIssuer(issure)
                .sign(algorithm);
    }

    public String getUsername(String token) {
        return JWT.decode(token).getClaim(USERNAME_KEY).asString();
    }

}
