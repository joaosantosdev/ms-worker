package br.com.ourmind.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ourmind.hruser.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
	
}
