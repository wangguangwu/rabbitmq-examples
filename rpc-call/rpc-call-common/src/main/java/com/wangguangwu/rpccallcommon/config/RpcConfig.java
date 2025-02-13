package com.wangguangwu.rpccallcommon.config;

import com.wangguangwu.rpccallcommon.constants.RpcConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RpcConfig 用于配置 RPC 模式下各个下游服务的交换机、队列及其绑定关系。
 *
 * @author wangguangwu
 */
@Configuration
public class RpcConfig {

    // --- Inventory 服务 ---
    @Bean
    public DirectExchange inventoryExchange() {
        return new DirectExchange(RpcConstants.INVENTORY_EXCHANGE);
    }

    @Bean
    public Queue inventoryQueue() {
        return new Queue(RpcConstants.INVENTORY_QUEUE);
    }

    @Bean
    public Binding inventoryBinding(@Qualifier("inventoryQueue") Queue inventoryQueue,
                                    @Qualifier("inventoryExchange") DirectExchange inventoryExchange) {
        return BindingBuilder.bind(inventoryQueue)
                .to(inventoryExchange)
                .with(RpcConstants.INVENTORY_ROUTING_KEY);
    }

    // --- Payment 服务 ---
    @Bean
    public DirectExchange paymentExchange() {
        return new DirectExchange(RpcConstants.PAYMENT_EXCHANGE);
    }

    @Bean
    public Queue paymentQueue() {
        return new Queue(RpcConstants.PAYMENT_QUEUE);
    }

    @Bean
    public Binding paymentBinding(@Qualifier("paymentQueue") Queue paymentQueue,
                                  @Qualifier("paymentExchange") DirectExchange paymentExchange) {
        return BindingBuilder.bind(paymentQueue)
                .to(paymentExchange)
                .with(RpcConstants.PAYMENT_ROUTING_KEY);
    }

    // --- Logistics 服务 ---
    @Bean
    public DirectExchange logisticsExchange() {
        return new DirectExchange(RpcConstants.LOGISTICS_EXCHANGE);
    }

    @Bean
    public Queue logisticsQueue() {
        return new Queue(RpcConstants.LOGISTICS_QUEUE);
    }

    @Bean
    public Binding logisticsBinding(@Qualifier("logisticsQueue") Queue logisticsQueue,
                                    @Qualifier("logisticsExchange") DirectExchange logisticsExchange) {
        return BindingBuilder.bind(logisticsQueue)
                .to(logisticsExchange)
                .with(RpcConstants.LOGISTICS_ROUTING_KEY);
    }
}
