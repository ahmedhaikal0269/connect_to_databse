package com.example.connect_to_databse.Services;

import com.example.connect_to_databse.Entities.User;
import com.example.connect_to_databse.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {

    @Autowired
    private UserRepository userRepository;

    public String createUser(String username, String mail, String firstName, String lastName, String password){
        if (userRepository.getMail(username).size() == 0) {
            userRepository.save(new User(username, mail, firstName, lastName, password));
            return "user created";
        }else{
            return "mail already exists";
        }

    }
}
