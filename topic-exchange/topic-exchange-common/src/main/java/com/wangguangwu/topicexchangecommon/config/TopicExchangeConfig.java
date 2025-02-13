package com.wangguangwu.topicexchangecommon.config;

import com.wangguangwu.topicexchangecommon.constants.StockExchangeConstants;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 创建 topic exchange
 *
 * @author wangguangwu
 */
@Configuration
public class TopicExchangeConfig {

    @Bean
    public TopicExchange stockTopicExchange() {
        return new TopicExchange(StockExchangeConstants.STOCK_TOPIC_EXCHANGE);
    }
}
