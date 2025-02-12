package com.wangguangwu.directexchangeproducer.controller;

import com.wangguangwu.directexchangeproducer.constants.RoutingKeyConstants;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangguangwu
 */
@RestController
@RequestMapping("/api/producer")
public class DirectExchangeProducer {

    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange logsExchange;

    @Autowired
    public DirectExchangeProducer(RabbitTemplate rabbitTemplate, DirectExchange logsExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.logsExchange = logsExchange;
    }

    @PostMapping("/send/info")
    public String sendInfoMessage(@RequestParam("message") String message) {
        rabbitTemplate.convertAndSend(logsExchange.getName(), RoutingKeyConstants.INFO_ROUTING_KEY, message);
        return "Sent INFO message: " + message;
    }

    @PostMapping("/send/warn")
    public String sendWarnMessage(@RequestParam("message") String message) {
        rabbitTemplate.convertAndSend(logsExchange.getName(), RoutingKeyConstants.WARN_ROUTING_KEY, message);
        return "Sent WARN message: " + message;
    }

    @PostMapping("/send/error")
    public String sendErrorMessage(@RequestParam("message") String message) {
        rabbitTemplate.convertAndSend(logsExchange.getName(), RoutingKeyConstants.ERROR_ROUTING_KEY, message);
        return "Sent ERROR message: " + message;
    }
}
