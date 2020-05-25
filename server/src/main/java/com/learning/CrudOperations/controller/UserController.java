package com.learning.CrudOperations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.CrudOperations.model.User;
import com.learning.CrudOperations.service.UserService;

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

}
