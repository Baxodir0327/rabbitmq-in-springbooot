package org.example.topicexchange.publisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessagePublisher {

    private final AmqpTemplate amqpTemplate;

    @Autowired
    public MessagePublisher(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void publishCustomerOrderLog(String message) {
        String routingKey = "order.logs.customer.electronics";
//        String message = "Customer order log for electronics";
        amqpTemplate.convertAndSend("order-logs-exchange", routingKey, message);
    }

}