package com.sioux.smartparkingapp.controller;

import com.sioux.smartparkingapp.Repo.UserRepository;
import com.sioux.smartparkingapp.models.User;
import com.sioux.smartparkingapp.servises.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<User> logIn(@RequestBody User user)
    {
        Optional<User> _user = userService.findByUserName(user.getUsername());
        if(_user.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else if(_user.get().getPassword().equals(user.getPassword()))
        {
            System.out.println(user.getPassword());
            System.out.println(_user.get().getPassword());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signIn(@RequestBody User user)
    {
        Optional<User> _user = userService.findByUserName(user.getUsername());
        if(_user.isEmpty())
        {
            userService.saveUser(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
