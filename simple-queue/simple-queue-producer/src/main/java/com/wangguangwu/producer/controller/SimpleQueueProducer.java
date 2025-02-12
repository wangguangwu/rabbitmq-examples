package com.wangguangwu.producer.controller;

import com.wangguangwu.producer.constants.QueueConstants;
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
public class SimpleQueueProducer {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public SimpleQueueProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        rabbitTemplate.convertAndSend(QueueConstants.SIMPLE_QUEUE, message);
        return "Message sent: " + message;
    }
}
