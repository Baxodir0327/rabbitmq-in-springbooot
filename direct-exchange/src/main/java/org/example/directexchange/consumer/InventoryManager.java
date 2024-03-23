package org.example.directexchange.consumer;

import org.example.directexchange.config.OrderProcessingConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class InventoryManager {

    @RabbitListener(queues = OrderProcessingConfig.INVENTORY_QUEUE)
    public void manageInventory(String orderId) {
        System.out.println("Inventory managed for order: " + orderId);
    }
}