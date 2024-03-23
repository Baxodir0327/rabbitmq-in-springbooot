package org.example.directexchange.publisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.directexchange.dto.Order;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static org.example.directexchange.config.OrderProcessingConfig.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderProducerService {


    private final RabbitTemplate rabbitTemplate;
    private final AmqpTemplate amqpTemplate;

    public void processOrderPayment(String orderId) {
        log.info("topic message for payment {}", orderId);
        rabbitTemplate.convertAndSend(ORDER_DIRECT_EXCHANGE, ROUTING_KEY_PAYMENT, orderId);
    }

    public void processOrderInventory(String orderId) {
        log.info("topic message for inventory {}", orderId);
        rabbitTemplate.convertAndSend(ORDER_DIRECT_EXCHANGE, ROUTING_KEY_INVENTORY, orderId);
    }

    public void processOrderShipping(String orderId) {
        log.info("topic message for shipping {}", orderId);
        rabbitTemplate.convertAndSend(ORDER_DIRECT_EXCHANGE, ROUTING_KEY_SHIPPING, orderId);
    }

    public void processOrderNot(Order order) {
        log.info("topic message for shipping {}", order.toString());
        amqpTemplate.convertAndSend(ORDER_DIRECT_EXCHANGE, ROUTING_KEY_NOTIFICATION, order);
    }
}