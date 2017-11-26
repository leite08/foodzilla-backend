package com.vanhack.rp.foodzilla.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.vanhack.rp.foodzilla.security.AuthenticationRequest;
import com.vanhack.rp.foodzilla.security.AuthenticationResponse;

@Service
public class SecurityService {

	private Logger log = Logger.getLogger(SecurityService.class);
	
	public AuthenticationResponse authenticate(AuthenticationRequest authRequest) {
		log.warn("Authentication service called with no default implementation");
		return null;
	}

}
