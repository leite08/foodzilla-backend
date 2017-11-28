package com.vanhack.rp.foodzilla.api;

import java.io.IOException;
import java.time.Instant;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.jr.ob.JSON;
import com.fasterxml.jackson.jr.ob.JSONObjectException;

@RestController
@RequestMapping("/api")
public class HomeApiController  {
	
	protected Logger log = Logger.getLogger(HomeApiController.class);
	
	@RequestMapping(name="/", method = RequestMethod.GET)
	public String info() throws JSONObjectException, JsonProcessingException, IOException {
		log.debug("Api home running...");
		String json = JSON.std
				  .composeString()
				  .startObject()
				    .put("title", "Foodzilla API")
				    .put("version", "1.0")
				    .put("timestamp", Instant.now().toString())
				  .end()
				  .finish();
		return json;
	}
}
