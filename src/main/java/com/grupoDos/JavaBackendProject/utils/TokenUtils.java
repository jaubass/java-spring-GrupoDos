package com.grupoDos.JavaBackendProject.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.crypto.SecretKey;
import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class TokenUtils {

    // Clave secreta
    private final static String ACCESS_TOKEN_SECRET;

    // Tiempo de validez del token
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_500_000L;


    static {
        String encodedKey;
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] secretKeyBytes = secretKey.getEncoded();
            encodedKey = Base64.getEncoder().encodeToString(secretKeyBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("Error generando clave secreta", e);
        }
        ACCESS_TOKEN_SECRET = encodedKey;
    }

    public static String createToken(String name, String email) {
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("name", name);

        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(SignatureAlgorithm.HS256, Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                    .parseClaimsJws(token)
                    .getBody();

            String email = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        } catch (JwtException e) {
            return null;
        }
    }


}
