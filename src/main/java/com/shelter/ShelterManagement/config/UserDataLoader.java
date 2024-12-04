package com.shelter.ShelterManagement.config;

import com.shelter.ShelterManagement.model.User;
import com.shelter.ShelterManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserDataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
            createUser("admin", "password1", "admin@gmail.com","ADMIN");
            createUser("Morad", "password2", "morad@gmail.com","USER");
    }


    private void createUser(String username, String rawPassword, String email, String role) {
        if(userRepository.findByUsername(username).isEmpty()) {
            String encodedPassword = passwordEncoder.encode(rawPassword);
            User user = new User();
            user.setUsername(username);
            user.setPassword(encodedPassword);
            user.setEmail(email);
            user.setRole(role);
            userRepository.save(user);
        } else {
            System.out.println("The user "+ username + " Already exists!");
        }

    }


}
