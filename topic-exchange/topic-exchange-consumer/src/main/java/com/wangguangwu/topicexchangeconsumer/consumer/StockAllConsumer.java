package com.wangguangwu.topicexchangeconsumer.consumer;

import com.wangguangwu.topicexchangecommon.constants.StockQueueConstants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 用于处理所有市场消息的监听器（使用通配符绑定的队列）
 *
 * @author wangguangwu
 */
@Component
public class StockAllConsumer {

    @RabbitListener(queues = StockQueueConstants.QUEUE_STOCK_ALL)
    public void handleAllMessage(String message) {
        System.out.println("【All Consumer】 Received: " + message);
    }
}
