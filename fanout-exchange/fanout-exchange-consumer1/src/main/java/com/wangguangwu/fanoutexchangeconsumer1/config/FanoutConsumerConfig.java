package com.wangguangwu.fanoutexchangeconsumer1.config;

import com.wangguangwu.fanoutexchangeconsumer1.constants.FanoutConstants;
import com.wangguangwu.fanoutexchangeconsumer1.constants.QueueConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangguangwu
 */
@Configuration
class FanoutConsumerConfig {

    @Bean
    public Queue logQueue() {
        return new Queue(QueueConstants.LOG_QUEUE_1, true);
    }

    @Bean
    public Queue notificationsQueue() {
        return new Queue(QueueConstants.NOTIFICATIONS_QUEUE, true);
    }

    @Bean
    public FanoutExchange logExchange() {
        return new FanoutExchange(FanoutConstants.LOG_EXCHANGE);
    }

    @Bean
    public FanoutExchange notificationsExchange() {
        return new FanoutExchange(FanoutConstants.NOTIFICATION_EXCHANGE);
    }

    @Bean
    public Binding bindingLogQueue(@Qualifier("logQueue") Queue logQueue, @Qualifier("logExchange") FanoutExchange logExchange) {
        return BindingBuilder.bind(logQueue).to(logExchange);
    }

    @Bean
    public Binding bindingNotificationsQueue(@Qualifier("notificationsQueue") Queue notificationsQueue, @Qualifier("notificationsExchange") FanoutExchange notificationsExchange) {
        return BindingBuilder.bind(notificationsQueue).to(notificationsExchange);
    }
}
