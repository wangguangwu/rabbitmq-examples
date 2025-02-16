package com.wangguangwu.fanoutexchangeconsumer.consumer;

import com.wangguangwu.fanoutexchangecommon.constants.RabbitMQConstants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wangguangwu
 */
@Component
public class FanoutExchangeConsumer {

    /**
     * 监听日志队列 1
     *
     * @param message 收到的消息
     */
    @RabbitListener(queues = RabbitMQConstants.LOG_QUEUE_1)
    public void receiveLogMessage1(String message) {
        System.out.println("[Consumer 1] Received from LOG_QUEUE_1: " + message);
    }

    /**
     * 监听日志队列 2
     *
     * @param message 收到的消息
     */
    @RabbitListener(queues = RabbitMQConstants.LOG_QUEUE_2)
    public void receiveLogMessage2(String message) {
        System.out.println("[Consumer 1] Received from LOG_QUEUE_2: " + message);
    }
}