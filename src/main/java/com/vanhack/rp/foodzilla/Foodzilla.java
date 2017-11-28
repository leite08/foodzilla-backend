package com.vanhack.rp.foodzilla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mashape.unirest.http.Unirest;

@SpringBootApplication
public class Foodzilla {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Foodzilla.class, args);
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		Unirest.shutdown();
	}
}