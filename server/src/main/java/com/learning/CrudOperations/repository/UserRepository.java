package com.learning.CrudOperations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.learning.CrudOperations.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
