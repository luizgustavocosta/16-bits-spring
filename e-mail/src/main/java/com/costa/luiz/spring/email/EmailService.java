package com.costa.luiz.spring.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Main idea from Greg
 * https://www.youtube.com/watch?v=ROADomQE8oU
 */
@Service
public class EmailService {

    @Value("${spring.mail.username}")
    private String from;

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void send(Email email) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setSubject(email.getSubject());
        mailMessage.setTo(email.getTo());
        mailMessage.setText(email.getText());
        this.mailSender.send(mailMessage);
    }
}
