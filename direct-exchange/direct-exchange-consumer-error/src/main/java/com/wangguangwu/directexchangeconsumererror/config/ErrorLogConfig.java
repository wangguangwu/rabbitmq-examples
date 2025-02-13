package com.wangguangwu.directexchangeconsumererror.config;

import com.wangguangwu.directexchangeconsumererror.constants.DirectExchangeConstants;
import com.wangguangwu.directexchangeconsumererror.constants.QueueConstants;
import com.wangguangwu.directexchangeconsumererror.constants.RoutingKeyConstants;
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
public class ErrorLogConfig {

    @Bean
    public DirectExchange logsExchange() {
        return new DirectExchange(DirectExchangeConstants.LOGS_EXCHANGE);
    }

    @Bean
    public Queue errorQueue() {
        return new Queue(QueueConstants.ERROR_QUEUE, true);
    }

    @Bean
    public Binding bindErrorQueue(Queue errorQueue, DirectExchange logsExchange) {
        return BindingBuilder.bind(errorQueue).to(logsExchange).with(RoutingKeyConstants.ERROR_ROUTING_KEY);
    }
}