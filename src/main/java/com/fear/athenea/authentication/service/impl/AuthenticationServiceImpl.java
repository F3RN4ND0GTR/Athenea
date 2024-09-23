package com.fear.athenea.authentication.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.fear.athenea.authentication.dto.AuthRequest;
import com.fear.athenea.authentication.service.AuthenticationService;
import com.fear.athenea.security.JWUtil;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	private AuthenticationManager authenticationManager;

    private JWUtil jwtUtil;
    
    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, JWUtil jwtUtil) {
    	this.authenticationManager = authenticationManager;
    	this.jwtUtil = jwtUtil;
    }
    
	@Override
	public String getToken(AuthRequest authRequest) {
		 try {
	            // Autentica el usuario usando AuthenticationManager
	            @SuppressWarnings("unused")
				Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
	            );

	            return jwtUtil.generateToken(authRequest.getUsername());
		 } catch(AuthenticationException e) {
				return "Invalid credentials";
		 }
	}

}
