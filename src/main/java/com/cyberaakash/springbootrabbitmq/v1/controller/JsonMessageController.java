package com.cyberaakash.springbootrabbitmq.v1.controller;

import com.cyberaakash.springbootrabbitmq.v1.dto.User;
import com.cyberaakash.springbootrabbitmq.v1.producer.RabbitMQJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cyberaakash/api/json")
public class JsonMessageController {

    private RabbitMQJsonProducer jsonProducer;

    public JsonMessageController(RabbitMQJsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
        jsonProducer.sendMessage(user);
        return ResponseEntity.ok("JSON message sent to rabbitMQ....");
    }
}
