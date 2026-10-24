package com.pulseops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class PulseopsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PulseopsApplication.class, args);
	}
	
	@Bean
	RestClient restClient() {
	    return RestClient.builder().build();
	}

}
