package com.kadu.RpgManager.test;

import java.util.Arrays;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.kadu.RpgManager.entities.RpgStory;
import com.kadu.RpgManager.entities.User;
import com.kadu.RpgManager.enums.RPGSystem;
import com.kadu.RpgManager.repositories.RpgStoryRepository;
import com.kadu.RpgManager.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {   
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RpgStoryRepository rpgStoryRepository;

    @Override
	public void run(String...args) throws Exception {

        User u1 = new User( "Carlos", "carlos@email", "123");
        User u2 = new User( "Jorge", "jorge@email", "123");

        userRepository.saveAll(Arrays.asList(u1, u2));

        RpgStory rs1 = new RpgStory("Aventura Sombria","Uma jornada épica.", RPGSystem.DND_5E, u1);
        RpgStory rs2 = new RpgStory("Mistério Oculto", "Segredos ancestrais.", RPGSystem.ORDEM_PARANORMAL, u2);

        rpgStoryRepository.saveAll(Arrays.asList(rs1, rs2));
    }

}
