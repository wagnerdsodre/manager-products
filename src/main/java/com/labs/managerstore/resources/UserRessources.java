package com.labs.managerstore.resources;


import java.net.URI;
import java.net.http.HttpRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<User> insertUser(@RequestBody User user){
		user = services.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> updateUser(
			@PathVariable(value = "id") Long id,
			@RequestBody User obj){
		obj = services.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable Long id){
		services.delete(id);
		return ResponseEntity.noContent().build();
	}

}
