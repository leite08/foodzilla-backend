package com.vanhack.rp.foodzilla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Foodzilla {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Foodzilla.class, args);
	}

}