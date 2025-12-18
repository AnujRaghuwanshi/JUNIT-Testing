package com.example.CRUDApplication.scheduler;

import com.example.CRUDApplication.Entity.User;
import com.example.CRUDApplication.Repository.UserRepository;
import com.example.CRUDApplication.Service.Implementation.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class SentimentEmailScheduler {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 58 12 * * ?")
    public void sendSentimentEmails(){
        log.info("Starting sentiment reminder email job");
        List<User> users = userRepository.findUsersForSentimentAnalysis();
        for(User user : users){
            emailService.sendmail(user.getEmail(), user.getUsername());
        }
        log.info("Sent {} sentiment reminder emails", users.size());
    }
}
