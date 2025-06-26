package com.example.auth.services;

import java.security.Signature;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.print.DocFlavor.STRING;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SignatureAlgorithm;

public class jwtservice {
    public static final String Secret="935807631346957H780957327594590O898725872376";
    public String generateToken(String email){
        Map<String,Object> claims=new HashMap<>();
        return createToken(claims,email);
    }
    private String createToken(HashMap<String,Object> claims,String email){
        return Jwts.builder()
        .setClaims(claims)
        .setSubject(email)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*24));
        .signWith(getSignKey(),SignatureAlgorithm,SHA256)
        .compact();
    }

}
