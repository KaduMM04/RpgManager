package com.kadu.RpgManager.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kadu.RpgManager.entities.User;
import com.kadu.RpgManager.dtos.UserDTO;
import com.kadu.RpgManager.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    public UserDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User with email not found" + email));

            return convertToDTO(user);
    }

    public UserDTO getUserById(UUID id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found "));
        return convertToDTO(user);
    }

    public void deleteUserById(UUID id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not foud")); 
        
            userRepository.delete(user);
    }

    public UserDTO updateUser(UUID id, UserDTO dto) {
        User existingUser = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

            existingUser.setName(dto.getName());
            existingUser.setEmail(dto.getEmail());
            existingUser.setPassword(dto.getPassword());

            User updatedUser = userRepository.save(existingUser);
            return convertToDTO(updatedUser);
    }

    public UserDTO convertToDTO(User user) {
	    if (user == null) {
	        throw new IllegalArgumentException("User cannot be null");
	    }
	    return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPassword());
	}
}
