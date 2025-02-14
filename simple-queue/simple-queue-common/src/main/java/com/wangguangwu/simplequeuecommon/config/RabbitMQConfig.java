package com.wangguangwu.simplequeuecommon.config;

import com.wangguangwu.simplequeuecommon.constants.QueueConstants;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangguangwu
 */
@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue simpleQueue() {
        // true 代表队列持久化
        return new Queue(QueueConstants.SIMPLE_QUEUE, true);
    }
}
