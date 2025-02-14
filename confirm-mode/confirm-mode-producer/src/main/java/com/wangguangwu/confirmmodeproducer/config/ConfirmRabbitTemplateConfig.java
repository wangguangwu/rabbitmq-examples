package com.wangguangwu.confirmmodeproducer.config;

import com.wangguangwu.confirmmodeproducer.util.CallbackUtils;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitTemplateConfig 用于配置生产者使用的 RabbitTemplate，
 * 包括设置消息转换器、开启 mandatory 模式及配置 ConfirmCallback 和 ReturnCallback 回调。
 *
 * @author wangguangwu
 */
@Configuration
public class ConfirmRabbitTemplateConfig {

    /**
     * 创建并配置 RabbitTemplate。
     *
     * @param connectionFactory 数据库连接工厂
     * @param messageConverter  消息转换器，由 MessageConverterConfig 提供
     * @return RabbitTemplate 实例
     */
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
                                         Jackson2JsonMessageConverter messageConverter) {
        // 如果 connectionFactory 是 CachingConnectionFactory，可以开启确认和返回
        if (connectionFactory instanceof org.springframework.amqp.rabbit.connection.CachingConnectionFactory) {
            org.springframework.amqp.rabbit.connection.CachingConnectionFactory cachingFactory =
                    (org.springframework.amqp.rabbit.connection.CachingConnectionFactory) connectionFactory;
            cachingFactory.setPublisherConfirmType(CachingConnectionFactory.ConfirmType.CORRELATED);
            cachingFactory.setPublisherReturns(true);
        }

        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter);
        template.setMandatory(true);

        // 设置回调
        template.setConfirmCallback(CallbackUtils.sendConfirmCallback());
        template.setReturnsCallback(CallbackUtils.setReturnsCallback());
        return template;
    }
}
