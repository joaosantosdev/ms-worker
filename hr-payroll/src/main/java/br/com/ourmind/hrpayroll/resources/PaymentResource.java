package br.com.ourmind.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.ourmind.hrpayroll.entities.Payment;
import br.com.ourmind.hrpayroll.services.PaymentService;


@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {
	
	@Autowired
	private PaymentService service;
	
	@HystrixCommand(fallbackMethod = "getPaymentFallback")
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) throws Exception{
		return ResponseEntity.ok(this.service.getPayment(workerId, days));
	}
	
	public ResponseEntity<Payment> getPaymentFallback(Long workerId, Integer days) throws Exception{
		return ResponseEntity.ok(new Payment("Fallback", 400.0, days));
	}

}
