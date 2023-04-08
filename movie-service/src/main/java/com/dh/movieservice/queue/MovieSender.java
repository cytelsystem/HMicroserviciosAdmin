package com.dh.movieservice.queue;

import com.dh.movieservice.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieSender {

    private final RabbitTemplate rabbitTemplate;

    private final Queue moviecatalogQueue;

    public void send(Movie movie) {
        this.rabbitTemplate.convertAndSend(this.moviecatalogQueue.getName(), movie);
    }


}
