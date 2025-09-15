package com.example.CRUDApplication.Service.Implementation;

import com.example.CRUDApplication.Entity.User;
import com.example.CRUDApplication.Repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomUserDetailsServiceTests {

    @Autowired
    private UserRepository userRepo;

    @Disabled  //To stop testcase execution
    @Test
    public void testFindByUserName(){
        Optional<User> user = userRepo.findByUsername("anuj");
        user.ifPresent(u->assertTrue(!u.getPassword().isEmpty()));
    }

    @ParameterizedTest   //For parameterizedTest , loop wil run for each case
    @CsvSource({
            "1,1,2",
            "2,10,12",
            "3,3,9"
    })
    public void testAdd(int a, int b, int exp){
        assertEquals(exp,a+b,"failed for: "+a+" "+b);
    }
}
