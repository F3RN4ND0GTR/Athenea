/**
 * 
 */
package com.fear.athenea.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fear.athenea.dto.AuthRequest;
import com.fear.athenea.security.JWUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

/**
 * @author Usuario
 *
 */
@RestController("/athenea")
public class AtheneaController {
	
    private AuthenticationManager authenticationManager;

    private JWUtil jwtUtil;
    
    public AtheneaController(AuthenticationManager authenticationManager, JWUtil jwtUtil) {
    	this.authenticationManager = authenticationManager;
    	this.jwtUtil = jwtUtil;
    }
	
	@PostMapping("/login")
	 public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        try {
            // Autentica el usuario usando AuthenticationManager
            @SuppressWarnings("unused")
			Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );

            String token = jwtUtil.generateToken(authRequest.getUsername());
        	return ResponseEntity.ok(token);
            
        } catch (AuthenticationException e) {
            // Si la autenticación falla, devuelve una respuesta no autorizada
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

}
