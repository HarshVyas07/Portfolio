package com.cognizant.MutualFundNavService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "MutualFundNAV API", version = "3.0", description = "Mutual Funds NAV Microservice Information"))
public class MutualFundNavServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MutualFundNavServiceApplication.class, args);
	}

}
