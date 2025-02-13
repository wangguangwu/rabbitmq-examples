package com.wangguangwu.topicexchangeconsumer.consumer;

import com.wangguangwu.topicexchangecommon.constants.StockQueueConstants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 用于处理 A 股消息的监听器
 *
 * @author wangguangwu
 */
@Component
public class StockCNConsumer {

    @RabbitListener(queues = StockQueueConstants.QUEUE_STOCK_A)
    public void handleCNMessage(String message) {
        System.out.println("【CN Consumer】 Received: " + message);
    }
}
