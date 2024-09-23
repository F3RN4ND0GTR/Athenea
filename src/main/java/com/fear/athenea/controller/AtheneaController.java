/**
 * 
 */
package com.fear.athenea.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fear.athenea.authentication.dto.AuthRequest;
import com.fear.athenea.authentication.dto.UserDto;
import com.fear.athenea.authentication.service.AuthenticationService;

import jakarta.validation.Valid;

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
	public ResponseEntity<?> register(@RequestBody UserDto registro) {

		return ResponseEntity.ok("");
	}

}
