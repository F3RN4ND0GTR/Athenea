package com.fear.athenea.authentication.service;

import com.fear.athenea.authentication.dto.AuthRequest;

public interface AuthenticationService {

	public String getToken(AuthRequest authRequest);

}
