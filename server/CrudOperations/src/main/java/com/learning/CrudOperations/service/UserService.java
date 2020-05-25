package com.learning.CrudOperations.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.learning.CrudOperations.repository.UserRepository;
import com.learning.CrudOperations.model.User;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public List<User> getAllUsers() {
		List<User> userList = repository.findAll();

		if (userList.size() > 0) {
			return userList;
		} else {
			return new ArrayList<User>();
		}
	}

	public User createUser(User user) {

		return repository.save(user);

	}

}
