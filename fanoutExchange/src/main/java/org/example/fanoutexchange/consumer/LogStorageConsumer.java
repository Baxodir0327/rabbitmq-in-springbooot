package org.example.fanoutexchange.consumer;

import org.example.fanoutexchange.dto.Emp;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class LogStorageConsumer {

    @RabbitListener(queues = "log-storage-queue")
    public void storeLog(Emp message) {
        System.out.println(message);
    }
}