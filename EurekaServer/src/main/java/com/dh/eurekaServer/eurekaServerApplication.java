package com.dh.eurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class eurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(eurekaServerApplication.class, args);
	}

}
