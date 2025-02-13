package com.wangguangwu.topicexchangecommon.config;

import com.wangguangwu.topicexchangecommon.constants.StockQueueConstants;
import com.wangguangwu.topicexchangecommon.constants.StockRoutingKeyConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * StockQueueConfig 用于配置股票相关队列及其与 Topic Exchange 的绑定关系。
 * <p>
 * 此配置类定义了以下队列：
 * <ul>
 *   <li>A 股队列</li>
 *   <li>美股队列</li>
 *   <li>港股队列</li>
 *   <li>所有市场队列</li>
 * </ul>
 * 每个队列均与 Topic Exchange 按相应的 routing key 进行绑定，
 * 以确保消息能够按照不同市场进行精准路由。
 * </p>
 *
 * @author wangguangwu
 */
@Configuration
@SuppressWarnings("all")
public class StockQueueConfig {

    /**
     * 创建 A 股队列。
     *
     * @return A 股队列对象
     */
    @Bean
    public Queue queueStockA() {
        return new Queue(StockQueueConstants.QUEUE_STOCK_A);
    }

    /**
     * 创建美股队列。
     *
     * @return 美股队列对象
     */
    @Bean
    public Queue queueStockUS() {
        return new Queue(StockQueueConstants.QUEUE_STOCK_US);
    }

    /**
     * 创建港股队列。
     *
     * @return 港股队列对象
     */
    @Bean
    public Queue queueStockHK() {
        return new Queue(StockQueueConstants.QUEUE_STOCK_HK);
    }

    /**
     * 创建所有市场队列。
     *
     * @return 所有市场队列对象
     */
    @Bean
    public Queue queueStockAll() {
        return new Queue(StockQueueConstants.QUEUE_STOCK_ALL);
    }

    /**
     * 将 A 股队列与对应的 routing key 绑定到 Topic Exchange 上。
     *
     * @param queueStockA        A 股队列对象
     * @param stockTopicExchange Topic Exchange 对象
     * @return A 股队列绑定对象
     */
    @Bean
    public Binding bindingStockA(@Qualifier("queueStockA") Queue queueStockA, TopicExchange stockTopicExchange) {
        return BindingBuilder.bind(queueStockA)
                .to(stockTopicExchange)
                .with(StockRoutingKeyConstants.STOCK_A_ROUTING_KEY);
    }

    /**
     * 将美股队列与对应的 routing key 绑定到 Topic Exchange 上。
     *
     * @param queueStockUS       美股队列对象
     * @param stockTopicExchange Topic Exchange 对象
     * @return 美股队列绑定对象
     */
    @Bean
    public Binding bindingStockUS(@Qualifier("queueStockUS") Queue queueStockUS, TopicExchange stockTopicExchange) {
        return BindingBuilder.bind(queueStockUS)
                .to(stockTopicExchange)
                .with(StockRoutingKeyConstants.STOCK_US_ROUTING_KEY);
    }

    /**
     * 将港股队列与对应的 routing key 绑定到 Topic Exchange 上。
     *
     * @param queueStockHK       港股队列对象
     * @param stockTopicExchange Topic Exchange 对象
     * @return 港股队列绑定对象
     */
    @Bean
    public Binding bindingStockHK(@Qualifier("queueStockHK") Queue queueStockHK, TopicExchange stockTopicExchange) {
        return BindingBuilder.bind(queueStockHK)
                .to(stockTopicExchange)
                .with(StockRoutingKeyConstants.STOCK_HK_ROUTING_KEY);
    }

    /**
     * 将所有市场队列与对应的 routing key 绑定到 Topic Exchange 上。
     *
     * @param queueStockAll      所有市场队列对象
     * @param stockTopicExchange Topic Exchange 对象
     * @return 所有市场队列绑定对象
     */
    @Bean
    public Binding bindingStockAll(@Qualifier("queueStockAll") Queue queueStockAll, TopicExchange stockTopicExchange) {
        return BindingBuilder.bind(queueStockAll)
                .to(stockTopicExchange)
                .with(StockRoutingKeyConstants.STOCK_ALL_ROUTING_KEY);
    }
}
