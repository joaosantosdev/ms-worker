package br.com.ourmind.hrworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HumanResourceWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumanResourceWorkerApplication.class, args);
	}

}