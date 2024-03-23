package org.example.topicexchange.cunsumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderLogConsumer {

    @RabbitListener(queues = "customer_orders_queue")
    public void processCustomerOrderLog(String message) {
        System.out.println("Received in customer_orders_queue: " + message);
    }
    @RabbitListener(queues = "electronics_order_logs_queue")
    public void processElectronicsOrderLogs(String message) {
        System.out.println("Received in electronics_order_logs_queue: " + message);
    }
}