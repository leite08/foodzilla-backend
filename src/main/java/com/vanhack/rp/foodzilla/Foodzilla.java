package com.vanhack.rp.foodzilla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mashape.unirest.http.Unirest;

@SpringBootApplication
public class Foodzilla {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Foodzilla.class, args);
	}
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
            	// TODO: define allowed origins (UI) and allow access only from them 
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		Unirest.shutdown();
	}
}