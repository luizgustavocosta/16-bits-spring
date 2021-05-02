package com.costa.luiz.spring.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/email")
public class EmailResource {

    @Autowired
    private final EmailService service;

    @Value("${email.to}")
    private String to;

    public EmailResource(EmailService service) {
        this.service = service;
    }

    @PostMapping
    public String sendMail() {
        service.send(Email.builder()
                .to(this.to)
                .subject("Spring Boot Mail")
                .text("New email using Spring Boot Mail")
                .build());
        return "E-mail sent";
    }
}
