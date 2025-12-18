package com.example.CRUDApplication.Service.Implementation;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Disabled
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Test
    @Disabled("Don't want to execute")
    void testSendEmail(){
        emailService.sendmail("anujraghuwanshipip04@gmail.com","anuj");
    }
}
