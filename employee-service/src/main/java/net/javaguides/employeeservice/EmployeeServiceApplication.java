package net.javaguides.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
// Enable Component Scanning for Interfaces that are declared as Feign (as @Service, @Component,..)
@EnableFeignClients
public class EmployeeServiceApplication {

	// @Bean registers RestTemplate in String IOC
//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
//
//	@Bean
//	public WebClient webClient() {
//		return WebClient.builder().build();
//	}
	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
