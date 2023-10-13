package com.labs.managerstore.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.labs.managerstore.models.User;
import com.labs.managerstore.repository.UserRepository;

@Profile("test")
@Configuration
public class testConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository repo;	
	
	@Override
	public void run(String... args) throws Exception {
		User user1 = new User("name","email","address","pass");
		User user2 = new User("name2","email2","address2","pass2");
		repo.saveAll(Arrays.asList(user1, user2));
		
	}
	

}
