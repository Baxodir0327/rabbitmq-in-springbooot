package org.example.fanoutexchange.consumer;

import org.example.fanoutexchange.dto.Emp;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationConsumer {

//    @RabbitListener(queues = "email-queue")
//    public void sendEmailNotification(String message) {
//        // Send email notification logic
//        System.out.println("Email Notification: " + message);
//    }

    @RabbitListener(queues = "email-queue")
    public void sendEmailNotification2(Emp message) {
        System.out.println(message);
    }
}