package org.example.topicexchange.controller;

import lombok.RequiredArgsConstructor;
import org.example.topicexchange.publisher.MessagePublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final MessagePublisher publisher;

    @PostMapping
    public String test(@RequestBody String message){
        publisher.publishCustomerOrderLog(message);
        return "OK";
    }
}
