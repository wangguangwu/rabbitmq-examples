package com.wangguangwu.confirmmodecommon.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MessageConverterConfig 用于配置消息转换器，
 * 这里使用 Jackson2JsonMessageConverter 实现 JSON 与对象的相互转换。
 *
 * @author wangguangwu
 */
@Configuration
public class MessageConverterConfig {

    /**
     * 创建一个 Jackson2JsonMessageConverter Bean，用于消息转换。
     *
     * @return Jackson2JsonMessageConverter 实例
     */
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
