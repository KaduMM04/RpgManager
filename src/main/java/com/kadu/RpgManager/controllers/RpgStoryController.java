package com.kadu.RpgManager.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kadu.RpgManager.dtos.RpgStoryDTO;
import com.kadu.RpgManager.dtos.UserDTO;
import com.kadu.RpgManager.services.RpgStoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/stories")
public class RpgStoryController {
    
    @Autowired
    private RpgStoryService rpgStoryService;

    @PostMapping
    public RpgStoryDTO createRpgStory(@RequestBody RpgStoryDTO rpgStoryDTO) {
            return rpgStoryService.createStory(rpgStoryDTO);
    }
    
    @GetMapping
    public ResponseEntity<List<RpgStoryDTO>> findAll() {
       List<RpgStoryDTO> storyDtosList = rpgStoryService.getAllStories();
       return ResponseEntity.ok().body(storyDtosList);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RpgStoryDTO>> getUserStories(@PathVariable UUID userId) {
        List<RpgStoryDTO> userStoryDtosList = rpgStoryService.getUserStories(userId);
        if(userStoryDtosList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(userStoryDtosList);
    }
    
}
