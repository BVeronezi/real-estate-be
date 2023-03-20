package com.brunsker.realestatebackend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API REAL ESTATE",
				version = "1.0.0"
		)
)
@EntityScan(basePackages = "com.brunsker.realestatebackend.*")
@ComponentScan(basePackages = "com.brunsker.realestatebackend.*")
@EnableFeignClients
public class RealestateBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealestateBackendApplication.class, args);
	}

}
