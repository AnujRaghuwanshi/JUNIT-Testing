package com.example.CRUDApplication.Service.Implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendmail(String to, String username){
        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(to);
            mail.setSubject("Enable Sentiment Analysis");
            mail.setText("Hello " + username + ",\n\n" +
                            "You haven’t enabled Sentiment Analysis yet.\n" +
                            "Please turn it ON to get better insights.\n\n" +
                            "Regards,\nAnuj Raghuwanshi");
            javaMailSender.send(mail);
        }catch (Exception e){
            log.error("Failed to send email to {}",to,e);
        }
    }
}
