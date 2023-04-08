package com.dh.movieservice.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSenderConfig {

    @Value("${queue.moviecatalogo.name}")
    private String moviecatalogQueue;


    @Bean
    public Queue queue() {
        return new Queue(this.moviecatalogQueue, true);
    }

}
