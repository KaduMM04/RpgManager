package com.kadu.RpgManager.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kadu.RpgManager.services.UserService;

import com.kadu.RpgManager.entities.User;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            user = userService.saveUser(user);
            return ResponseEntity.ok().body(user);
        } catch(RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
       List<User> userList = userService.getAllUsers();
       return ResponseEntity.ok().body(userList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable UUID id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }

    @PutMapping(value = "/{id}")
	public ResponseEntity<User> updateUser(@PathVariable UUID id, @RequestBody User userData) {
		User user = userService.updateUser(id, userData);
		if (user == null) {
	        return ResponseEntity.notFound().build();
	    }

		return ResponseEntity.ok().body(user);
	}
    
    @DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
		userService.deleteUserById(id);
		return ResponseEntity.noContent().build();
	}
}