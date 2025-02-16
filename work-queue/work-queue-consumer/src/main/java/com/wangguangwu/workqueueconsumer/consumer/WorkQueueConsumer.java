package com.wangguangwu.workqueueconsumer.consumer;

import com.wangguangwu.workqueuecommon.constants.QueueConstants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author wangguangwu
 */
@Service
public class WorkQueueConsumer {

    @RabbitListener(queues = QueueConstants.WORK_QUEUE)
    public void worker(String message) {
        System.out.println("Received: " + message + " - " + Thread.currentThread().getName());
    }
}
