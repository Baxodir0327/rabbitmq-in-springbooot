package org.example.directexchange.consumer;

import org.example.directexchange.dto.Order;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static org.example.directexchange.config.OrderProcessingConfig.NOTIFICATION_QUEUE;


@Service
public class NotificationService {

    @RabbitListener(queues = NOTIFICATION_QUEUE)
    public void receiveOrderCreatedEvent(Order order) {
        System.out.println("Received order created event: " + order);
    }
}