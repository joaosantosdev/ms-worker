package br.com.ourmind.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ourmind.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
