package br.com.ourmind.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ourmind.hruser.entities.User;
import br.com.ourmind.hruser.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) throws Exception{
		User user = this.userRepository.findById(id).orElseThrow(() -> new Exception("Not Found"));
		user.setPassword(null);
		return ResponseEntity.ok(user);
	}

	@GetMapping(value = "/search")
	public ResponseEntity<User> findById(@RequestParam String email) throws Exception{
		User user = this.userRepository.findByEmail(email);
		if(user == null) {
			throw new Exception("Not Found");
		}
		user.setPassword(null);
		return ResponseEntity.ok(user);
	}

}
