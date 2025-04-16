package com.review.hex_with_ddd.core.authentication.infrastructure.jwt;

import com.review.hex_with_ddd.core.authentication.infrastructure.config.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final JwtConfig jwtConfig;

    public String generateToken(String username) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + 1000 * 60 * 60); // 1h
        String secret = jwtConfig.secret();
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());

        return Jwts.builder()
              .setSubject(username)
              .setIssuedAt(now)
              .setExpiration(expiry)
              .signWith(key, SignatureAlgorithm.HS256)
              .compact();
    }

    public boolean isValid(String token) {
        String secret = jwtConfig.secret();
        try {
            Jwts.parserBuilder()
                  .setSigningKey(secret.getBytes())
                  .build()
                  .parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    public Authentication getAuthentication(String token) {
        String secret = jwtConfig.secret();
        Claims claims = Jwts.parserBuilder()
              .setSigningKey(secret.getBytes())
              .build()
              .parseClaimsJws(token)
              .getBody();

        String username = claims.getSubject();
        return new UsernamePasswordAuthenticationToken(username, null, List.of());
    }

}
