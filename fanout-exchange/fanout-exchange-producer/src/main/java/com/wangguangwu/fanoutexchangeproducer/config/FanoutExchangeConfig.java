package com.wangguangwu.fanoutexchangeproducer.config;

import com.wangguangwu.fanoutexchangeproducer.constants.FanoutConstants;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangguangwu
 */
@Configuration
class FanoutExchangeConfig {

    @Bean
    public FanoutExchange notificationExchange() {
        return new FanoutExchange(FanoutConstants.NOTIFICATION_EXCHANGE);
    }

    @Bean
    public FanoutExchange logExchange() {
        return new FanoutExchange(FanoutConstants.LOG_EXCHANGE);
    }
}