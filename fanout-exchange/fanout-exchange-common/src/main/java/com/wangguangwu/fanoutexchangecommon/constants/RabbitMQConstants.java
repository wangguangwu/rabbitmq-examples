package com.wangguangwu.fanoutexchangecommon.constants;

/**
 * RabbitMQ 相关常量定义
 * 用于定义交换机、队列等名称，避免硬编码
 *
 * @author wangguangwu
 */
public final class RabbitMQConstants {

    // 交换机名称
    public static final String LOG_EXCHANGE = "fanout.exchange.logs";

    // 队列名称
    public static final String LOG_QUEUE_1 = "log.queue.1";
    public static final String LOG_QUEUE_2 = "log.queue.2";

    // 私有构造方法，防止实例化
    private RabbitMQConstants() {
    }
}