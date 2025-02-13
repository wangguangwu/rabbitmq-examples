package com.wangguangwu.topicexchangeconsumer.consumer;

import com.wangguangwu.topicexchangecommon.constants.StockQueueConstants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 用于处理港股消息的监听器
 *
 * @author wangguangwu
 */
@Component
public class StockHKConsumer {

    @RabbitListener(queues = StockQueueConstants.QUEUE_STOCK_HK)
    public void handleHKMessage(String message) {
        System.out.println("【HK Consumer】 Received: " + message);
    }
}
