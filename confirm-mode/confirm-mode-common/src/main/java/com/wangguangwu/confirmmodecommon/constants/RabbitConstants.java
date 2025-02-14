package com.wangguangwu.confirmmodecommon.constants;

/**
 * 定义交换机、队列和路由键名称
 *
 * @author wangguangwu
 */
public final class RabbitConstants {

    public static final String EXCHANGE_NAME = "confirm.exchange";
    public static final String QUEUE_NAME = "confirm.queue";
    public static final String ROUTING_KEY = "confirm.routingKey";
    public static final String INVALID_ROUTING_KEY = "invalid.routing.key";

    private RabbitConstants() {
    }
}
