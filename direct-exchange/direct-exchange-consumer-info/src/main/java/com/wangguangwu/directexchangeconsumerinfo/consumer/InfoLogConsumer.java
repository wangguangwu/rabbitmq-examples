package com.wangguangwu.directexchangeconsumerinfo.consumer;

import com.wangguangwu.directexchangeconsumerinfo.constants.QueueConstants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author wangguangwu
 */
@Service
public class InfoLogConsumer {

    @RabbitListener(queues = QueueConstants.INFO_QUEUE)
    public void receiveInfoLog(String message) {
        System.out.println("[INFO Consumer] Received: " + message);
    }
}
