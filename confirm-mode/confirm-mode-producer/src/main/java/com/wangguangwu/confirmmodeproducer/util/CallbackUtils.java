package com.wangguangwu.confirmmodeproducer.util;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * CallbackUtils 封装了 ConfirmCallback 和 ReturnsCallback 方法
 * 用于配置 RabbitTemplate 的回调逻辑。
 *
 * @author wangguangwu
 */
public class CallbackUtils {

    /**
     * 返回 ConfirmCallback，用于确认消息是否到达 Broker
     *
     * @return RabbitTemplate.ConfirmCallback 实例
     */
    public static RabbitTemplate.ConfirmCallback sendConfirmCallback() {
        return (correlationData, ack, cause) -> {
            System.out.println("ConfirmCallback: correlationData=" + correlationData
                    + ", ack=" + ack + ", cause=" + cause);
            if (!ack) {
                System.err.println("消息未成功送达 Broker: " + cause);
            }
        };
    }

    /**
     * 返回 ReturnsCallback，用于处理无法路由到队列的消息
     *
     * @return RabbitTemplate.ReturnsCallback 实例
     */
    public static RabbitTemplate.ReturnsCallback setReturnsCallback() {
        return returnedMessage -> System.out.println("ReturnsCallback: message=" + returnedMessage.getMessage() +
                ", replyCode=" + returnedMessage.getReplyCode() +
                ", replyText=" + returnedMessage.getReplyText() +
                ", exchange=" + returnedMessage.getExchange() +
                ", routingKey=" + returnedMessage.getRoutingKey());
    }
}