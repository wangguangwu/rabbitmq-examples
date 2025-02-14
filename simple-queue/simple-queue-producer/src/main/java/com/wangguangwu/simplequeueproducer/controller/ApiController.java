package com.wangguangwu.simplequeueproducer.controller;

import com.wangguangwu.simplequeuecommon.constants.QueueConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangguangwu
 */
@RestController
@RequestMapping("/api/producer")
@RequiredArgsConstructor
public class ApiController {

    private final RabbitTemplate rabbitTemplate;

    @PostMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        rabbitTemplate.convertAndSend(QueueConstants.SIMPLE_QUEUE, message);
        return "Message sent: " + message;
    }
}
