package com.wangguangwu.directexchangeconsumererror.consumer;

import com.wangguangwu.directexchangeconsumererror.constants.QueueConstants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author wangguangwu
 */
@Service
public class WarnLogConsumer {

    @RabbitListener(queues = QueueConstants.ERROR_QUEUE)
    public void receiveInfoLog(String message) {
        System.out.println("[ERROR Consumer] Received: " + message);
    }
}
