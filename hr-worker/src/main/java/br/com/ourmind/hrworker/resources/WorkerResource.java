package br.com.ourmind.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ourmind.hrworker.entities.Worker;
import br.com.ourmind.hrworker.repositories.WorkerRepository;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	private static Logger log = LoggerFactory.getLogger(WorkerResource.class);

	@Value("${test.config}")
	private String config;

	@Autowired
	private Environment env;

	@Autowired
	private WorkerRepository workerRepository;

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		return ResponseEntity.ok(this.workerRepository.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) throws Exception {
		log.info("PORT = " + this.env.getProperty("local.server.port"));
		return ResponseEntity.ok(this.workerRepository.findById(id).orElseThrow(() -> new Exception("Not Found")));
	}

	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfigs() {
		log.info("CONFIG: " + this.config);
		return ResponseEntity.noContent().build();
	}

}
