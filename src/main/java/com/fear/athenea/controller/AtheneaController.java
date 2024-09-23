/**
 * 
 */
package com.fear.athenea.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fear.athenea.authentication.dto.AuthRequest;
import com.fear.athenea.authentication.dto.RegisterDto;
import com.fear.athenea.authentication.service.AuthenticationService;
import com.fear.athenea.security.JWUtil;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Usuario
 *
 */
@RestController
@RequestMapping("/athenea")
@Validated
public class AtheneaController {

	private AuthenticationService service;

	public AtheneaController(AuthenticationService service) {
		this.service = service;
	}

	@GetMapping("/login")
	public ResponseEntity<?> login(@RequestBody @Valid AuthRequest authRequest) {
		String token = "";

		token = service.getToken(authRequest);

		if (!token.equals("Invalid credentials")) {
			return ResponseEntity.status(401).body("Invalid credentials");
		} else {
			return ResponseEntity.ok(token);
		}
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody RegisterDto registro) {

		return ResponseEntity.ok("");
	}

}
