package com.jwt.util;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Jutil {
	
	//generate token
	
	public String generateToken(String id,String audience,String issuer,String subject,String key) {
		
		
		
		return Jwts.builder()
				.setId(id)
				.setAudience(audience)
				.setIssuer(issuer)
				.setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(10)))
				.signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(key.getBytes()))
				.compact();	
	}
	//get claims
	public Claims getClaims(String key,String token) {
		
		return Jwts.parser()
				.setSigningKey(Base64.getEncoder().encode(key.getBytes()))
				.parseClaimsJws(token)
				.getBody();
	}
	
	//get subject
	
	public String getSub(String key,String token) {
		
		return getClaims(key,token).getSubject();
	}
	
	//token is valid or not
	
	public boolean tokenValid(String key,String token) {
		
		//expire date >> current date
		
		return getClaims(key,token).getExpiration().after(new Date(System.currentTimeMillis()));
	}

}
