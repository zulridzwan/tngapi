package com.plusmilesdev.tngapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TngapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TngapiApplication.class, args);
	}
	
	
	@Bean
	public RestTemplate restTemplateFactory() {
		return new RestTemplate();
	}

}
