package com.vanhack.rp.foodzilla.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {
	
//	private Logger log = Logger.getLogger(ConfigService.class);
	
	// TODO: move to a database configuration 
	@Value("${config.authToken}")
	private String authToken;

	public String getAuthToken() {
		return authToken;
	}
}
