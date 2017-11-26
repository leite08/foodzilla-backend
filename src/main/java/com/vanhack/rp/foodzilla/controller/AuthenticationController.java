package com.vanhack.rp.foodzilla.controller;

import java.net.HttpURLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vanhack.rp.foodzilla.security.AuthenticationRequest;
import com.vanhack.rp.foodzilla.security.AuthenticationResponse;
import com.vanhack.rp.foodzilla.service.SecurityService;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController extends AbstractCloudController {

	Logger log = Logger.getLogger(AuthenticationController.class);
	
	private SecurityService securityService;
	
	@Autowired
	AuthenticationController(SecurityService ss) {
		this.securityService = ss;
	}

	@RequestMapping(method = RequestMethod.POST)
	AuthenticationResponse authenticate(HttpServletRequest request, HttpServletResponse response,
			@RequestBody AuthenticationRequest authRequest) throws Exception {
		log.debug("Begin authenticate() - " + request.getRequestURI());
		long localTime = System.currentTimeMillis();
		try {
			AuthenticationResponse authResponse = securityService.authenticate(authRequest);
			if (authResponse.getStatus().equals(AuthenticationResponse.Status.FAILURE)) {
				response.sendError(HttpURLConnection.HTTP_UNAUTHORIZED, authResponse.getMessage());
			}
			return authResponse;

		} finally {
			log.debug(String.format("End authenticate(), took %d milliseconds", System.currentTimeMillis() - localTime));
		}
	}

}
