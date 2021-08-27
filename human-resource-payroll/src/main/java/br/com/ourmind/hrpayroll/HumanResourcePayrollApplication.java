package br.com.ourmind.hrpayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RibbonClient(name = "human-resource-worker")
@EnableFeignClients
@SpringBootApplication
public class HumanResourcePayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumanResourcePayrollApplication.class, args);
	}

}
