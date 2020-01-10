package com.example.demo.controller;

import java.util.List;
import java.util.Objects;

import javax.jws.soap.SOAPBinding.Use;
import javax.management.RuntimeErrorException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.User;
import com.example.demo.exceptionhandler.CustomResponseEntity;
import com.example.demo.service.UserService;

@RestController
@RequestMapping(path = "users")
public class UserManagementController {

	@Autowired
	private UserService userService;

	/**
	 * 
	 * @param name
	 * @return
	 */
	@GetMapping("/")
	public List<User> getAllUsers(@RequestParam(required = false) String name) {
		// throw new RuntimeException("Name not found");
		return (Objects.isNull(name)) ? userService.getUsers() : userService.getUsersByFirstName(name);

	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<CustomResponseEntity> getUser(@PathVariable long id) {
		CustomResponseEntity customResponseEntity = new CustomResponseEntity(HttpStatus.OK, "data has retrived",
				userService.getUserById(id));

		return new ResponseEntity<CustomResponseEntity>(customResponseEntity, customResponseEntity.getStatus());

	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("/")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {

		return new ResponseEntity(userService.createUser(user), HttpStatus.OK);

	}

	/**
	 * 
	 * @param id
	 * @param user
	 */
	@PutMapping("/{id}")
	public void updateUser(@PathVariable long id, @RequestBody User user) {
		userService.updateUser(user, id);
	}

	/**
	 * 
	 * @param user
	 */
	@DeleteMapping("/")
	public void deleteUser(@RequestBody User user) {

		userService.deleteUser(user);

	}

	/**
	 * 
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable long id) {

		userService.deleteUser(id);

	}

}
