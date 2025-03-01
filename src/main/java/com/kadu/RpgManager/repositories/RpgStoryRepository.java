package com.kadu.RpgManager.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kadu.RpgManager.entities.RpgStory;

@Repository
public interface RpgStoryRepository extends JpaRepository<RpgStory, UUID> {
    
    List<RpgStory> findByUserId(UUID userId);
    
}
