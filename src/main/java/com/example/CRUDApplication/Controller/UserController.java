package com.example.CRUDApplication.Controller;

import com.example.CRUDApplication.Entity.User;
import com.example.CRUDApplication.Service.Implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/sentiment")
    public List<User> getUserForSentiment(){
        return userService.getUsersForSentimentAnalysis();
    }


}
