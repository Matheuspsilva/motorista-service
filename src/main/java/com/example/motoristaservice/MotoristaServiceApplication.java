package com.example.motoristaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MotoristaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MotoristaServiceApplication.class, args);
	}

}
