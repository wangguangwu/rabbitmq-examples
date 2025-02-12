package com.wangguangwu.workqueueproducer.controller;

import com.wangguangwu.workqueueproducer.constants.QueueConstants;
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
public class WorkQueueProducer {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public WorkQueueProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        rabbitTemplate.convertAndSend(QueueConstants.WORK_QUEUE, message);
        return "Message sent: " + message;
    }
}
