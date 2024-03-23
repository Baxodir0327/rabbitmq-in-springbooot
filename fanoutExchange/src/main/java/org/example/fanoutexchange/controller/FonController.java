package org.example.fanoutexchange.controller;

import lombok.RequiredArgsConstructor;
import org.example.fanoutexchange.dto.Emp;
import org.example.fanoutexchange.publisher.NotificationProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FonController {
    private final NotificationProducer producer;

    @PostMapping("/sms")
    public String notificationSMS(@RequestBody Emp emp) {
        producer.sendSMSNotification(emp);
        return "ok";
    }
}
