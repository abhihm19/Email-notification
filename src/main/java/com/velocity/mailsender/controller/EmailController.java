package com.velocity.mailsender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.velocity.mailsender.service.EmailService;

@RestController
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/send-email/{name}")
    public ResponseEntity<String> sendEmail(@PathVariable String name) {
        try {
            emailService.sendEmail("abhishekhm.m7@gmail.com", name);
            return new ResponseEntity<>("Email sent successfully", HttpStatus.OK);
        } catch (Exception e) {
        	e.printStackTrace();
            return new ResponseEntity<>("Failed to send email", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

