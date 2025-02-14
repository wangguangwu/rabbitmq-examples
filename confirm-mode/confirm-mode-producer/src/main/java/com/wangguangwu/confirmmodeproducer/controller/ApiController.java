package com.wangguangwu.confirmmodeproducer.controller;

import com.wangguangwu.confirmmodecommon.constants.RabbitConstants;
import com.wangguangwu.confirmmodeproducer.dto.MessageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangguangwu
 */
@RestController
@RequestMapping("/api/confirm")
@RequiredArgsConstructor
public class ApiController {

    private final RabbitTemplate confirmRabbitTemplate;

    /**
     * POST /api/confirm/send
     * 接收外部请求发送消息
     *
     * @param request 包含消息内容的请求体
     * @return 返回发送结果信息
     */
    @PostMapping("/sendTest")
    public ResponseEntity<String> sendTestMessage(@RequestBody MessageRequest request,
                                                  @RequestParam(name = "testType", defaultValue = "success") String testType) {
        // 默认使用正确的路由键
        String routingKey = RabbitConstants.ROUTING_KEY;
        // 如果 testType 为 failure，则故意使用错误的路由键
        if ("failure".equalsIgnoreCase(testType)) {
            routingKey = RabbitConstants.INVALID_ROUTING_KEY;
        }

        // 构造一个唯一的 CorrelationData 对象，便于在 ConfirmCallback 中获取信息
        CorrelationData correlationData = new CorrelationData("msg-" + System.currentTimeMillis());

        // 发送消息到指定的交换机和路由键
        confirmRabbitTemplate.convertAndSend(RabbitConstants.EXCHANGE_NAME, routingKey, request.getMessage(), correlationData);

        return ResponseEntity.ok("消息已发送: " + request.getMessage() + ", testType: " + testType);
    }
}