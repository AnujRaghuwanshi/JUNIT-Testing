package com.example.CRUDApplication.Controller;

import com.example.CRUDApplication.Entity.User;
import com.example.CRUDApplication.Repository.UserRepository;
import com.example.CRUDApplication.securityJWT.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user){
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepo.save(user);
            return new ResponseEntity("User registered Successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){
        var dbuser = userRepo.findByUsername(user.getUsername()).orElseThrow(()->new RuntimeException("User not found"));
        if(passwordEncoder.matches(user.getPassword(), dbuser.getPassword())){
            String token = jwtUtil.generateToken(user.getUsername());
            return ResponseEntity.ok(token);
        }else{
            return ResponseEntity.status(401).body("Invalid Credentials");
        }
    }
}
