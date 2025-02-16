package com.wangguangwu.fanoutexchangecommon.config;

import com.wangguangwu.fanoutexchangecommon.constants.RabbitMQConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ 配置类，配置 Fanout 交换机、队列及其绑定关系
 *
 * @author wangguangwu
 */
@Configuration
public class RabbitMQConfig {

    /**
     * 创建 Fanout 交换机
     * FanoutExchange 采用广播模式，将消息发送到所有绑定的队列
     *
     * @return FanoutExchange 实例
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(RabbitMQConstants.LOG_EXCHANGE);
    }

    /**
     * 创建日志队列 1
     *
     * @return Queue 实例
     */
    @Bean
    public Queue logQueue1() {
        return new Queue(RabbitMQConstants.LOG_QUEUE_1);
    }

    /**
     * 创建日志队列 2
     *
     * @return Queue 实例
     */
    @Bean
    public Queue logQueue2() {
        return new Queue(RabbitMQConstants.LOG_QUEUE_2);
    }

    /**
     * 绑定日志队列 1 到 Fanout 交换机
     *
     * @param fanoutExchange Fanout 交换机
     * @param logQueue1      队列 1
     * @return 绑定关系
     */
    @Bean
    public Binding bindLogQueue1(FanoutExchange fanoutExchange, Queue logQueue1) {
        return BindingBuilder.bind(logQueue1).to(fanoutExchange);
    }

    /**
     * 绑定日志队列 2 到 Fanout 交换机
     *
     * @param fanoutExchange Fanout 交换机
     * @param logQueue2      队列 2
     * @return 绑定关系
     */
    @Bean
    public Binding bindLogQueue2(FanoutExchange fanoutExchange, Queue logQueue2) {
        return BindingBuilder.bind(logQueue2).to(fanoutExchange);
    }
}
