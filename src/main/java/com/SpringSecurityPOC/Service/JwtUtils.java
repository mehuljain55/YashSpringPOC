package com.SpringSecurityPOC.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtUtils {

    private  final SecretKey secretKey= Keys.secretKeyFor(SignatureAlgorithm.HS256);


    public  String generateToken(String userID) {
        return Jwts.builder()
                .setSubject(userID)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60))
                .signWith(secretKey)
                .compact();
    }


    public boolean validateToken(String token,String userId) {
        try {
            Claims claims=Jwts.parser().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
            String token_userId=claims.getSubject().toString();
            System.out.println("Token user:"+token_userId);
            System.out.println("Requested User:"+userId);
            System.out.println("Status:"+isTokenExpired(claims));
           return  (userId.equals(token_userId)&& !isTokenExpired(claims));
        } catch (JwtException e) {
            return false;

        }
    }
    public boolean isTokenExpired(Claims claims)
    {
        return claims.getExpiration().before(new Date());
    }
}
