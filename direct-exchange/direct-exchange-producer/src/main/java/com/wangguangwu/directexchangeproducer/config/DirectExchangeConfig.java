package com.wangguangwu.directexchangeproducer.config;

import com.wangguangwu.directexchangeproducer.constants.DirectExchangeConstants;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangguangwu
 */
@Configuration
class DirectExchangeConfig {

    @Bean
    public DirectExchange logsExchange() {
        return new DirectExchange(DirectExchangeConstants.LOGS_EXCHANGE);
    }

}