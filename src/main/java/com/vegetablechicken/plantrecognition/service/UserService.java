package com.vegetablechicken.plantrecognition.service;

import com.vegetablechicken.plantrecognition.entity.User;
import com.vegetablechicken.plantrecognition.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserService  {

    @Resource
    private UserRepository userRepository;

    public String login(String username,String password){
        Optional<User> user=userRepository.findById(username);
        if(user.get().getPassword().equals(password)){
            return "login succeed";
        }
        else{
            return "login failed";
        }

    }

    public String signup(String username,String password){

        return "test";
    }
}
