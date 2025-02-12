package com.wangguangwu.fanoutexchangeconsumer1.consumer;

import com.wangguangwu.fanoutexchangeconsumer1.constants.QueueConstants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author wangguangwu
 */
@Service
public class FanoutExchangeConsumer {

    @RabbitListener(queues = QueueConstants.NOTIFICATIONS_QUEUE)
    public void receiveNotificationsMessage(String message) {
        System.out.println("[Consumer 1] Received from NOTIFICATIONS_EXCHANGE: " + message);
    }

    @RabbitListener(queues = QueueConstants.LOG_QUEUE_1)
    public void receiveLogMessage(String message) {
        System.out.println("[Consumer 1] Received from LOG_EXCHANGE: " + message);
    }

}