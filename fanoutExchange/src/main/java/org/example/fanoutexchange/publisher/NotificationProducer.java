package org.example.fanoutexchange.publisher;

import lombok.RequiredArgsConstructor;
import org.example.fanoutexchange.dto.Emp;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static org.example.fanoutexchange.config.NotificationConfig.NOTIFICATION_FANOUT_EXCHANGE;

@RequiredArgsConstructor
@Service
public class NotificationProducer {


    private final RabbitTemplate rabbitTemplate;



    public void sendEmailNotification(Emp emp) {
        rabbitTemplate.convertAndSend(NOTIFICATION_FANOUT_EXCHANGE, "", emp);
    }

    public void sendSMSNotification(Emp emp) {
        rabbitTemplate.convertAndSend(NOTIFICATION_FANOUT_EXCHANGE, "", emp);
    }

    public void sendLogToStorage(Emp emp) {
        rabbitTemplate.convertAndSend(NOTIFICATION_FANOUT_EXCHANGE, "",  emp);
    }
}