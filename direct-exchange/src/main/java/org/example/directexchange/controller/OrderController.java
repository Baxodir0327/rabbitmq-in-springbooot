package org.example.directexchange.controller;

import lombok.RequiredArgsConstructor;
import org.example.directexchange.dto.Order;
import org.example.directexchange.publisher.OrderProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class OrderController {
    private final OrderProducerService orderProducerService;

    @PostMapping("/payment")
    public ResponseEntity<String> sendToPayment(@RequestParam String orderId) {
        orderProducerService.processOrderPayment(orderId);
        return ResponseEntity.ok("Topic message sent to payment RabbitMQ....");
    }

    @PostMapping("/inventory")
    public ResponseEntity<String> sendToInventory(@RequestParam String orderId) {
        orderProducerService.processOrderInventory(orderId);
        return ResponseEntity.ok("Topic message sent to inventory RabbitMQ....");
    }

    @PostMapping("/shipping")
    public ResponseEntity<String> sendToShipping(@RequestParam String orderId) {
        orderProducerService.processOrderShipping(orderId);
        return ResponseEntity.ok("Topic message sent to shipping RabbitMQ....");
    }
    @PostMapping("/notification")
    public ResponseEntity<String> sendToNot(@RequestBody Order order) {
        orderProducerService.processOrderNot(order);
        return ResponseEntity.ok("Topic message sent to shipping RabbitMQ....");
    }

}
