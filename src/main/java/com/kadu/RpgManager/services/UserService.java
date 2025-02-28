package com.kadu.RpgManager.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kadu.RpgManager.entities.User;
import com.kadu.RpgManager.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(UUID id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } 
         throw new RuntimeException("User not found" + id);
    }

    public void deleteUserById(UUID id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not foud")); 
        
            userRepository.delete(user);
    }

    public User updateUser(UUID id, User userData) {
        User existingUser = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

            existingUser.setName(userData.getName());
            existingUser.setEmail(userData.getEmail());
            existingUser.setPassword(userData.getPassword());
    
            return userRepository.save(existingUser);
    }
}
