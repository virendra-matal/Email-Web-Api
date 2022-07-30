package com.intellij.boot.controller;

import com.intellij.boot.model.EmailBean;
import com.intellij.boot.model.response;
import com.intellij.boot.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@CrossOrigin
public class EmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping("/test")
    public String test(){

        return "Welcome";
    }

    @PostMapping("/sendmail")
    public ResponseEntity<?> Email(@RequestBody EmailBean bean){
        System.out.println("Data: "+bean);
        try {
            boolean email = this.emailService.sendEmail(bean.getTo(), bean.getMessage(), bean.getSubject());
            if (email){
                return ResponseEntity.ok(new response("Email is sent!!"));
            }else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new response("Email is not sent!!"));
            }
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
