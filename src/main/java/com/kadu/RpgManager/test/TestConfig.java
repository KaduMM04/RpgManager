package com.kadu.RpgManager.test;

import java.util.Arrays;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.kadu.RpgManager.entities.User;
import com.kadu.RpgManager.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {   
    
    @Autowired
    private UserRepository userRepository;

    @Override
	public void run(String...args) throws Exception {

        User u1 = new User( "Carlos", "carlos@email", "123");
        User u2 = new User( "Jorge", "jorge@email", "123");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }

}
