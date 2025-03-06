package com.kadu.RpgManager.dtos;

import java.util.UUID;

import com.kadu.RpgManager.enums.RPGSystem;

public class RpgStoryDTO {

    private UUID id;
    private String title;
    private String description;
    private RPGSystem system;
    private UUID userId;

    public RpgStoryDTO(UUID id, String title, String description, RPGSystem system, UUID userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.system = system;
        this.userId = userId;
    }

  
    public UUID getId() { 
        return id; 
    }

    public void setId(UUID id) { 
        this.id = id; 
    }

    public String getTitle() {
         return title; 
        }

    public void setTitle(String title) { 
        this.title = title; 
    }

    public String getDescription() { 
        return description;
     }

    public void setDescription(String description) {
         this.description = description; 
        }

    public RPGSystem getSystem() {
         return system; 
        }

    public void setSystem(RPGSystem system) { 
        this.system = system; 
    }

    public UUID getUserId() { 
        return userId; 
    }
    
    public void setUserId(UUID userId) {
         this.userId = userId; 
    }
}  

