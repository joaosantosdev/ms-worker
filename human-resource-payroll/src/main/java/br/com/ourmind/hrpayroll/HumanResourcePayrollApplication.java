package br.com.ourmind.hrpayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class HumanResourcePayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumanResourcePayrollApplication.class, args);
	}

}
