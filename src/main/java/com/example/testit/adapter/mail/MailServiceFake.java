package com.example.testit.adapter.mail;

import com.example.testit.model.User;
import org.springframework.stereotype.Service;

@Service
public class MailServiceFake implements MailService {

    @Override
    public void sendMail(User user, String subject, String message) {
        // Fake : juste afficher ou pas de log
        System.out.println("Fake Mail to " + user.getUsername() + ": " + subject + " - " + message);
    }

    @Override
    public void sendMailCloture(User user) {
        sendMail(user, "Tâche terminée", "Votre tâche a été terminée.");
    }
}
