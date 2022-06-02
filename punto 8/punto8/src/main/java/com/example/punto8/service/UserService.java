package com.example.punto8.service;

import com.example.punto8.model.User;
import com.example.punto8.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findBYNameAndPassword(String name, String password){
        return  userRepository.findByNameAndPassword(name, password);
    }
}
