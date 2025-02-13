package com.wangguangwu.topicexchangeconsumer.consumer;

import com.wangguangwu.topicexchangecommon.constants.StockQueueConstants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 用于处理美股消息的监听器
 *
 * @author wangguangwu
 */
@Component
public class StockUSConsumer {

    @RabbitListener(queues = StockQueueConstants.QUEUE_STOCK_US)
    public void handleUSMessage(String message) {
        System.out.println("【US Consumer】 Received: " + message);
    }
}
