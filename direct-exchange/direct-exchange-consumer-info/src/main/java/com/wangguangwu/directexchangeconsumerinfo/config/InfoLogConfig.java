package com.wangguangwu.directexchangeconsumerinfo.config;

import com.wangguangwu.directexchangeconsumerinfo.constants.QueueConstants;
import com.wangguangwu.directexchangeconsumerinfo.constants.RoutingKeyConstants;
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
public class InfoLogConfig {

    @Bean
    public Queue infoQueue() {
        return new Queue(QueueConstants.INFO_QUEUE, true);
    }

    @Bean
    public Binding bindInfoQueue(Queue infoQueue, DirectExchange logsExchange) {
        return BindingBuilder.bind(infoQueue).to(logsExchange).with(RoutingKeyConstants.INFO_ROUTING_KEY);
    }
}