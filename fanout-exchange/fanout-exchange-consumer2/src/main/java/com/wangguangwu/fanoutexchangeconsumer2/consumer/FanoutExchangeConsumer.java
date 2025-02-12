package com.wangguangwu.fanoutexchangeconsumer2.consumer;

import com.wangguangwu.fanoutexchangeconsumer2.constants.QueueConstants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author wangguangwu
 */
@Service
public class FanoutExchangeConsumer {

    @RabbitListener(queues = QueueConstants.LOG_QUEUE_2)
    public void receiveLogMessage(String message) {
        System.out.println("[Consumer 2] Received from LOG_EXCHANGE: " + message);
    }
}

