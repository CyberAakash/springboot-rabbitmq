package com.cyberaakash.springbootrabbitmq.v1.producer;

import com.cyberaakash.springbootrabbitmq.v1.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonProducer {
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.json_routing.key}")
    private String routing_key;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducer.class);

    private RabbitTemplate rabbitTemplate;

    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    //    Send Message
    public void sendMessage(User user) {
        LOGGER.info(String.format("JSON Message sent --> %s", user.toString()));
        rabbitTemplate.convertAndSend(exchange,routing_key,user);
    }
}
