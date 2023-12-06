package com.cg.mentorservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class MentorServiceApplication {

	@Bean
	public WebClient webClient(){
		return WebClient.builder().build();
	}
	
//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MentorServiceApplication.class, args);
	}

}
