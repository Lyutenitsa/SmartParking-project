package com.sioux.smartparkingapp.servises;

import com.sioux.smartparkingapp.Repo.UserRepository;
import com.sioux.smartparkingapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public String deleteUser(Long id){
        userRepository.deleteById(id);
        return "User removed";
    }

    public String updateUserDetails(User user){
        userRepository.save(user);
        return "user Details updated successfully";
    }
    public Optional<User> findByUserName(String username){
        return userRepository.findByUsername(username);
    }
}
