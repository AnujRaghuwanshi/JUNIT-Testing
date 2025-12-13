package com.example.CRUDApplication.Service.Implementation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Test
    void testSendEmail(){
        emailService.sendmail("anujraghuwanshipip04@gmail.com","Testing Java Mail Sender","Hi,How are you?");
    }
}
