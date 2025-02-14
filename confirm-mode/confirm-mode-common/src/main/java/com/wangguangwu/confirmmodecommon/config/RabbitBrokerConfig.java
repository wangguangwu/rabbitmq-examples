package com.wangguangwu.confirmmodecommon.config;

import com.wangguangwu.confirmmodecommon.constants.RabbitConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitBrokerConfig 用于配置 RabbitMQ 与 Broker 相关的组件，
 * 包括交换机、队列以及它们之间的绑定关系。
 *
 * @author wangguangwu
 */
@Configuration
public class RabbitBrokerConfig {

    /**
     * 创建一个 DirectExchange，名称由 RabbitConstants.EXCHANGE_NAME 指定。
     *
     * @return DirectExchange 实例
     */
    @Bean
    public DirectExchange confirmExchange() {
        return new DirectExchange(RabbitConstants.EXCHANGE_NAME);
    }

    /**
     * 创建一个 Queue，名称由 RabbitConstants.QUEUE_NAME 指定。
     *
     * @return Queue 实例
     */
    @Bean
    public Queue confirmQueue() {
        return new Queue(RabbitConstants.QUEUE_NAME);
    }

    /**
     * 将 confirmQueue 与 confirmExchange 绑定，并使用 RabbitConstants.ROUTING_KEY 指定路由键。
     *
     * @param confirmQueue    队列实例
     * @param confirmExchange 交换机实例
     * @return Binding 实例
     */
    @Bean
    public Binding binding(Queue confirmQueue, DirectExchange confirmExchange) {
        return BindingBuilder.bind(confirmQueue)
                .to(confirmExchange)
                .with(RabbitConstants.ROUTING_KEY);
    }
}
