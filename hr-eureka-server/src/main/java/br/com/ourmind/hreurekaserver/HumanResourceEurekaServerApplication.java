package br.com.ourmind.hreurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HumanResourceEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumanResourceEurekaServerApplication.class, args);
	}

}