package com.learning.CrudOperations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.CrudOperations.model.User;
import com.learning.CrudOperations.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService service;

	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}

	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user) {

		User _user = service.createUser(user);
		return new ResponseEntity<>(_user, HttpStatus.CREATED);
	}

	@GetMapping("/findUserById/{id}")
	public ResponseEntity<User> findUserById(@PathVariable("id") long id) {
		User _user = service.findUserById(id);
		return new ResponseEntity<>(_user, HttpStatus.OK);
	}
	
	@PostMapping("/updateUser")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		User _user = service.updateUser(user);
		return new ResponseEntity<>(_user, HttpStatus.CREATED);
	}

}
