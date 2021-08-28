package br.com.ourmind.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.ourmind.hroauth.entities.User;
import br.com.ourmind.hroauth.feignclients.UserFeignClient;

@Service
public class UserService implements  UserDetailsService{

	Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient userClient;

	public User findByEmail(String email) throws UsernameNotFoundException {
		User user = this.userClient.findByEmail(email).getBody();
		log.info("USER: "+user);
		if (user == null) {
			throw new UsernameNotFoundException("Email not found");
		}

		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("TETE"+username);
		User user = this.findByEmail(username);
		return user;
	}

}
