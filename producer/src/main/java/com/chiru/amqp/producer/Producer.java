package com.chiru.amqp.producer;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Producer
 */
@RestController
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DirectExchange excahnge;
    
    @GetMapping("/")
    public void produceSomeData(){
        rabbitTemplate.convertAndSend(excahnge.getName(), "participant-create", "For 'participant-create' Key");
        rabbitTemplate.convertAndSend(excahnge.getName(), "With out Routing Key");
        rabbitTemplate.convertAndSend("With out Routing Key and Exchange name");
        rabbitTemplate.convertAndSend(excahnge.getName(), "channel-create", "For 'channel-create' Key");
        rabbitTemplate.convertAndSend(excahnge.getName(), "admin", "For 'admin' Key");
    }
}