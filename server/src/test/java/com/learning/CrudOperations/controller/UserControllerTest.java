package com.learning.CrudOperations.controller;

import com.learning.CrudOperations.model.User;
import com.learning.CrudOperations.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    UserService userService;

    @Test
    void getAllUsers() {
        User user1 = new User();
        User user2 = new User();
        when(userService.getAllUsers()).thenReturn(Arrays.asList(user1, user2));

        List<User> result = userController.getAllUsers();

        assertEquals(2, result.size());
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void createUser() {
        User user = new User();
        when(userService.createUser(any(User.class))).thenReturn(user);

        ResponseEntity<User> result = userController.createUser(user);

        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        verify(userService, times(1)).createUser(user);
    }

    @Test
    void findUserById() {
        User user = new User();
        when(userService.findUserById(anyLong())).thenReturn(user);

        ResponseEntity<User> result = userController.findUserById(1L);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        verify(userService, times(1)).findUserById(1L);
    }

    @Test
    void updateUser() {
        User user = new User();
        when(userService.updateUser(any(User.class))).thenReturn(user);

        ResponseEntity<User> result = userController.updateUser(user);

        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        verify(userService, times(1)).updateUser(user);
    }
}