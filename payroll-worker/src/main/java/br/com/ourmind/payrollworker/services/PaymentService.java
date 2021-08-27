package br.com.ourmind.payrollworker.services;

import org.springframework.stereotype.Service;

import br.com.ourmind.payrollworker.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(Long workerId, Integer days) {
		return new Payment("Teste", 30.0, days);
	}

}
