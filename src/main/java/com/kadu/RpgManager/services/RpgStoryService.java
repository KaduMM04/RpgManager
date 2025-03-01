package com.kadu.RpgManager.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadu.RpgManager.dtos.RpgStoryDTO;
import com.kadu.RpgManager.entities.RpgStory;
import com.kadu.RpgManager.entities.User;
import com.kadu.RpgManager.repositories.RpgStoryRepository;
import com.kadu.RpgManager.repositories.UserRepository;

@Service
public class RpgStoryService {

    @Autowired
    private RpgStoryRepository rpgStoryRepository;

    @Autowired
    private UserRepository userRepository;

    public RpgStoryDTO createStory(RpgStoryDTO rpgStoryDTO) {
        User user = userRepository.findById(rpgStoryDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        RpgStory rpgStory = new RpgStory( rpgStoryDTO.getTitle(), rpgStoryDTO.getDescription(),  rpgStoryDTO.getSystem(), user);
        rpgStory = rpgStoryRepository.save(rpgStory);     

        return new RpgStoryDTO(rpgStoryDTO.getId(), rpgStoryDTO.getTitle(), rpgStoryDTO.getDescription(), rpgStoryDTO.getSystem(), user.getId()); 
    }
    
    public List<RpgStoryDTO> getAllStories() {
        return rpgStoryRepository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    public List<RpgStoryDTO> getUserStories(UUID userId) {
        List<RpgStory> stories = rpgStoryRepository.findByUserId(userId); // CORRIGIDO
        return stories.stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    public RpgStoryDTO convertToDTO(RpgStory story) {
	    if (story == null) {
	        throw new IllegalArgumentException("Rpg story cannot be null");
	    }
	    return new RpgStoryDTO(story.getId(), story.getTitle(), story.getDescription(), story.getSystem(), story.getUser().getId());
	}
}

