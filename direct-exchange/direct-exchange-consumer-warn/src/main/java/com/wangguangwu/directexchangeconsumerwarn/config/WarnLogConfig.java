package com.wangguangwu.directexchangeconsumerwarn.config;

import com.wangguangwu.directexchangeconsumerwarn.constants.DirectExchangeConstants;
import com.wangguangwu.directexchangeconsumerwarn.constants.QueueConstants;
import com.wangguangwu.directexchangeconsumerwarn.constants.RoutingKeyConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangguangwu
 */
@Configuration
public class WarnLogConfig {

    @Bean
    public DirectExchange logsExchange() {
        return new DirectExchange(DirectExchangeConstants.LOGS_EXCHANGE);
    }

    @Bean
    public Queue warnQueue() {
        return new Queue(QueueConstants.WARN_QUEUE, true);
    }

    @Bean
    public Binding bindInfoQueue(Queue warnQueue, DirectExchange logsExchange) {
        return BindingBuilder.bind(warnQueue).to(logsExchange).with(RoutingKeyConstants.WARN_ROUTING_KEY);
    }
}