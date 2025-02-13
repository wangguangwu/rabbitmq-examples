package com.wangguangwu.topicexchangeproducer.controller;

import com.wangguangwu.topicexchangecommon.constants.StockRoutingKeyConstants;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangguangwu
 */
@RestController
@RequestMapping("/api/producer")
public class TopicExchangeProducer {

    private final RabbitTemplate rabbitTemplate;
    private final TopicExchange stockTopicExchange;

    @Autowired
    public TopicExchangeProducer(RabbitTemplate rabbitTemplate, TopicExchange stockTopicExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.stockTopicExchange = stockTopicExchange;
    }

    @PostMapping("/send/A")
    public String sendAStock(@RequestParam("message") String message) {
        rabbitTemplate.convertAndSend(
                stockTopicExchange.getName(),
                StockRoutingKeyConstants.STOCK_A_ROUTING_KEY,
                message
        );
        return "Sent A股 message: " + message;
    }

    @PostMapping("/send/US")
    public String sendUSStock(@RequestParam("message") String message) {
        rabbitTemplate.convertAndSend(
                stockTopicExchange.getName(),
                StockRoutingKeyConstants.STOCK_US_ROUTING_KEY,
                message
        );
        return "Sent 美股 message: " + message;
    }

    @PostMapping("/send/HK")
    public String sendHKStock(@RequestParam("message") String message) {
        rabbitTemplate.convertAndSend(
                stockTopicExchange.getName(),
                StockRoutingKeyConstants.STOCK_HK_ROUTING_KEY,
                message
        );
        return "Sent 港股 message: " + message;
    }
}
