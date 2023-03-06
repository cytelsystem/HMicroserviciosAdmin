package com.dh.apiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class apiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(apiGatewayApplication.class, args);
	}

}