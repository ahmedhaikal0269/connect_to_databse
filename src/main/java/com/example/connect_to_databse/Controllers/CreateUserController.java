package com.example.connect_to_databse.Controllers;

import com.example.connect_to_databse.Entities.User;
import com.example.connect_to_databse.Services.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateUserController {

    @Autowired
    private CreateUserService createUserService;

    @PostMapping("/create_user")
    public ResponseEntity<?> createUser(@RequestBody User user){
        String res = createUserService.createUser(user.getUsername()
                                                 ,user.getMail()
                                                 ,user.getFirstName()
                                                 ,user.getLastName()
                                                 ,user.getPassword());
        if (res == "user created") {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
