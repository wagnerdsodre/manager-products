package com.labs.managerstore.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labs.managerstore.models.User;
import com.labs.managerstore.services.UserServices;

@RestController
@RequestMapping(value = "/users")
public class UserRessources {
	
	@Autowired
	private UserServices services;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> users = services.findAll();		
		return ResponseEntity.ok().body(users);			
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findUserId(@PathVariable(value = "id") Long id){
		User obj= services.findById(id);		
		return ResponseEntity.ok().body(obj);			
	}
	

}
