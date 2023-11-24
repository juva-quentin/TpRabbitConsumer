package com.quentin.tprabbitmqconsumer.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quentin.tprabbitmqconsumer.model.User;
import com.quentin.tprabbitmqconsumer.service.EmailService;
import com.quentin.tprabbitmqconsumer.service.TokenGenerator;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationListener {

    @Autowired
    private EmailService emailService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TokenGenerator tokenGenerator;


    @RabbitListener(queues = "Rabbit")
    public void receiveMessage(String message) {
        String email = extractEmailFromMessage(message);
        String token = tokenGenerator.generateToken();
        String url = "http://localhost:8080/users/validation?token=" + token;
        String text = "Veuillez cliquer sur le lien suivant pour valider votre compte : " + url;
        emailService.sendEmail(email, "Bienvenue", "Votre compte a été créé avec succès.\n"+text);
    }

    private String extractEmailFromMessage(String message) {
        try {
            User user = objectMapper.readValue(message, User.class);
            return user.getEmail();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
