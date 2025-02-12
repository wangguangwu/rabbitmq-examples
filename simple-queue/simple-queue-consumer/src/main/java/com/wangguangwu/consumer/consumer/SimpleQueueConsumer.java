package com.wangguangwu.consumer.consumer;

import com.wangguangwu.consumer.constants.QueueConstants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author wangguangwu
 */
@Service
public class SimpleQueueConsumer {

    @RabbitListener(queues = QueueConstants.SIMPLE_QUEUE)
    public void handleMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
