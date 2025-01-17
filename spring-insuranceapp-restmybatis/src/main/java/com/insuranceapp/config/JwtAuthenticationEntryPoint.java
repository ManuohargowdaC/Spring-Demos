package com.insuranceapp.config;

import javax.naming.AuthenticationException;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationEntryPoint {
	 public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException, Exception {
	        // to send error message to the client
	        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"UnAuthorized");
	    }

}
