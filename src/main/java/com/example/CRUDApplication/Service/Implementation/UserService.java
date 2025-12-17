package com.example.CRUDApplication.Service.Implementation;

import com.example.CRUDApplication.Entity.User;
import com.example.CRUDApplication.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsersForSentimentAnalysis() {
        return userRepository.findUsersForSentimentAnalysis();
    }
}
