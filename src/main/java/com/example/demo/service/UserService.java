package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.User;
import com.example.demo.exceptionhandler.DataNotFoundException;
import com.example.demo.exceptionhandler.InsertionException;
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
				List<User> list= repository.findAll();
				if(list.isEmpty())throw new DataNotFoundException("Data Not Found");
				return list;
			}
			
			public List<User> getUsersByFirstName(String name) {
			
				List<User> list= repository.findAllByFirstName(name);
				if(list.isEmpty())throw new DataNotFoundException("Data Not Found");
				return list;
			}
			
			public User getUserById(long id) {
				User user= (User)repository.findById(id).get();
					if(user == null)throw new DataNotFoundException("Data Not Found");
					return user;
			}
	
			public User createUser(User user) {
				User userExists= repository.findById(user.getId()).get();
				if(userExists!=null)throw new InsertionException("Data Already Exists..!");
				
				return repository.saveAndFlush(user);
				
			}
			
			public void updateUser(User user,long id) {
				User userExists= repository.findById(id).get();
				if(userExists==null) {
					throw new DataNotFoundException("User does not exists..!!");
				}
				userExists.setTechnology(user.getTechnology());
				repository.save(userExists);
						
			}
			
			public void deleteUser(User entity) {
				repository.delete(entity);
			}
			
			public void deleteUser( long id) {
				repository.deleteById(id);
			}
}
