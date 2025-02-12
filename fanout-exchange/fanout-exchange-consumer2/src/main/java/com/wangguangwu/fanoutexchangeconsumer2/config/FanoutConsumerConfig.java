package com.wangguangwu.fanoutexchangeconsumer2.config;

import com.wangguangwu.fanoutexchangeconsumer2.constants.FanoutConstants;
import com.wangguangwu.fanoutexchangeconsumer2.constants.QueueConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangguangwu
 */
@Configuration
class FanoutConsumerConfig {

    @Bean
    public Queue logQueue() {
        return new Queue(QueueConstants.LOG_QUEUE_2, true);
    }

    @Bean
    public FanoutExchange logExchange() {
        return new FanoutExchange(FanoutConstants.LOG_EXCHANGE);
    }

    @Bean
    public Binding bindingLogQueue(Queue logQueue, FanoutExchange logExchange) {
        return BindingBuilder.bind(logQueue).to(logExchange);
    }
}
