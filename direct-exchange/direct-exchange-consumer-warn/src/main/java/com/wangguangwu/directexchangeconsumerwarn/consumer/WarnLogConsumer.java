package com.wangguangwu.directexchangeconsumerwarn.consumer;

import com.wangguangwu.directexchangeconsumerwarn.constants.QueueConstants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author wangguangwu
 */
@Service
public class WarnLogConsumer {

    @RabbitListener(queues = QueueConstants.WARN_QUEUE)
    public void receiveInfoLog(String message) {
        System.out.println("[WARN Consumer] Received: " + message);
    }
}
