package org.example.fanoutexchange.consumer;

import org.example.fanoutexchange.dto.Emp;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SMSNotificationConsumer {

    @RabbitListener(queues = "sms-queue")
    public void sendSMSNotification(Emp message) {
        System.out.println(message);
    }
}