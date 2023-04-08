package com.example.msregistro.core.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSenderConfig {

    @Value("${queue.seriecatalogo.name}")
    private String seriecatalogQueue;


    @Bean
    public Queue queue() {
        return new Queue(this.seriecatalogQueue, true);
    }

}
