package com.sioux.smartparkingapp.controller;

import com.sioux.smartparkingapp.Repo.IUserRepo;
import com.sioux.smartparkingapp.models.Appointment;
import com.sioux.smartparkingapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private IUserRepo userRepo;

    @PostMapping("/login")
    public ResponseEntity<User> logIn(@RequestBody User user)
    {
        Optional<User> _user = userRepo.findByUsername(user.getUsername());
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
        Optional<User> _user = userRepo.findByUsername(user.getUsername());
        if(_user.isEmpty())
        {
            userRepo.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
