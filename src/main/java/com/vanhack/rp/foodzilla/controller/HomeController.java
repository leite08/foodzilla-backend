package com.vanhack.rp.foodzilla.controller;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController extends AbstractCloudController {

	private Logger log = Logger.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	String home(HttpServletRequest request) {
		log.debug("Home running... - " + request.getRequestURI());
		return "FOODZILLA BACKEND"
			+ "<br>... running for URI " + request.getRequestURI()
			+ "<br>... at " + Instant.now().toString();
	}
}
