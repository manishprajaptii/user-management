package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.User;
import com.example.demo.repo.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	 	
			/**
			 * return list of all the user present in the database from  user table.
			 * @return
			 */
			public List<User> getUsers() {
				return repository.findAll();
			}
			
			public List<User> getUsersByFirstName(String name) {
			
				return repository.findAllByFirstName(name);
			}
			
			public User getUserById(long id) {
					return repository.findById(id).get();
			}
	
			public User createUser(User user) {
				return repository.saveAndFlush(user);
				
			}
			
			public void updateUser(User user,long id) {
				User userExists= repository.findById(id).get();
				if(userExists!=null) {
					userExists.setTechnology(user.getTechnology());
					repository.save(userExists);
				}
				 
						
			}
			
			public void deleteUser(User entity) {
				repository.delete(entity);
			}
			
			public void deleteUser( long id) {
				repository.deleteById(id);
			}
}
