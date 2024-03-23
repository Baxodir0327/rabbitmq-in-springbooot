package org.example.directexchange.consumer;

import org.example.directexchange.config.OrderProcessingConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentProcessor {

    @RabbitListener(queues = OrderProcessingConfig.PAYMENT_QUEUE)
    public void processPayment(String orderId) {
        System.out.println("Payment processed for order: " + orderId);
    }
}