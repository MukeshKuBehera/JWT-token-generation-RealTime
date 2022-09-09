package com.jwt;

import com.jwt.util.Jutil;

import io.jsonwebtoken.Claims;


public class App 
{
    public static void main( String[] args )
    {
       Jutil jutil=new Jutil();
       
       jutil.generateToken("101","Developer","client","Application not running","1234");
      // jutil.getClaims(key,token);
    	//jutil.getSub(key,sub);
       //jutil.tokenValid(key,token);
		/*
		 * Claims c=jutil.getClaims(key,token); System.out.println(c.getId());
		 * System.out.println(c.getAudience()); System.out.println(c.getIssuer());
		 * System.out.println(c.getSubject()); System.out.println( "Hello World!" );
		 */
    }
}
