package com.wangguangwu.confirmmodeconsumer.consumer;

import com.wangguangwu.confirmmodecommon.constants.RabbitConstants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wangguangwu
 */
@Component
public class ConfirmConsumer {

    /**
     * 监听队列，当有消息到达时自动调用此方法处理
     *
     * @param message 接收到的消息内容
     */
    @RabbitListener(queues = RabbitConstants.QUEUE_NAME)
    public void receiveMessage(String message) {
        System.out.println("消费者收到消息: " + message);
    }
}
