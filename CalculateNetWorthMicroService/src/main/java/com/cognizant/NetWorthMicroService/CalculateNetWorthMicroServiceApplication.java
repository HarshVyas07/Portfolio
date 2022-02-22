package com.cognizant.NetWorthMicroService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "Calculate Net Worth  API", version = "3.0", description = "Calculates net worth microservice from 2 other Microservices"))
public class CalculateNetWorthMicroServiceApplication {

	public static void main(String[] args) {     
		SpringApplication.run(CalculateNetWorthMicroServiceApplication.class, args);
	}

}
