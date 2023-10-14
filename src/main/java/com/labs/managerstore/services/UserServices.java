package com.labs.managerstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labs.managerstore.models.User;
import com.labs.managerstore.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();		
	}	
	
	public User insert(User u) {
		return repository.save(u);
	}
	
	
	public User update(Long id, User u) {
		User entity = repository.getReferenceById(id);
		entity.setName(u.getName());
		entity.setAddress(u.getAddress());
		entity.setEmail(u.getEmail());		
		return repository.save(entity);		
	}
	
	
	public void delete(Long id) {
		User entity = repository.getReferenceById(id);
		repository.deleteById(entity.getId());		
	}
	

}
