package com.wangguangwu.fanoutexchangeproducer.controller;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangguangwu
 */
@RestController
@RequestMapping("/api/producer")
public class FanoutExchangeProducer {

    private final RabbitTemplate rabbitTemplate;
    private final List<FanoutExchange> fanoutExchanges;

    @Autowired
    public FanoutExchangeProducer(RabbitTemplate rabbitTemplate, List<FanoutExchange> fanoutExchanges) {
        this.rabbitTemplate = rabbitTemplate;
        this.fanoutExchanges = fanoutExchanges;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        fanoutExchanges.forEach(exchange -> rabbitTemplate.convertAndSend(exchange.getName(), "", message));
        return "Message sent to all Fanout Exchanges: " + message;
    }
}
