package org.example.directexchange.consumer;

import org.example.directexchange.config.OrderProcessingConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ShippingHandler {

    @RabbitListener(queues = OrderProcessingConfig.SHIPPING_QUEUE)
    public void handleShipping(String orderId) {
        System.out.println("Order shipped: " + orderId);
    }
}