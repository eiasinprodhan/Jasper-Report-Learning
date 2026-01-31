package com.springboot.practice.service;

import com.springboot.practice.dto.request.UserRequest;
import com.springboot.practice.dto.response.UserResponse;
import com.springboot.practice.entity.User;
import com.springboot.practice.exeption.CustomException;
import com.springboot.practice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponse createUser(UserRequest request){
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        userRepository.save(user);

        UserResponse userResponse = new UserResponse(user.getId(), user.getName(), user.getEmail());

        return userResponse;
    }

    public List<UserResponse> getAllUser(){
        return userRepository.findAll().stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getName(),
                        user.getEmail()
                )).collect(Collectors.toList());
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new CustomException("User not found"));
    }
}
