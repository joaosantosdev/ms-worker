package br.com.ourmind.payrollworker.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.ourmind.payrollworker.entities.Payment;
import br.com.ourmind.payrollworker.entities.Worker;

@Service
public class PaymentService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${human-resource-worker.host}")
	private String humanResourceHost;

	public Payment getPayment(Long workerId, Integer days) throws Exception {
		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("id", String.valueOf(workerId));

		Worker worker = this.restTemplate.getForObject(this.humanResourceHost + "/workers/{id}", Worker.class,
				uriVariables);

		if (worker == null)
			throw new Exception("Worker not found");

		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
