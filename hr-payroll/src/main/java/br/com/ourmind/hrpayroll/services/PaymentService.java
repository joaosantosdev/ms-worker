package br.com.ourmind.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ourmind.hrpayroll.entities.Payment;
import br.com.ourmind.hrpayroll.entities.Worker;
import br.com.ourmind.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient wokerFeignClient;

	public Payment getPayment(Long workerId, Integer days) throws Exception {

		Worker worker = this.wokerFeignClient.findById(workerId).getBody();

		if (worker == null)
			throw new Exception("Worker not found");

		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
