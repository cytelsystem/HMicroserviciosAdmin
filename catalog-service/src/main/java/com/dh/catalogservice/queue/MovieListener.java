package com.dh.catalogservice.queue;

import com.dh.catalogservice.model.MovieMongoDTO;
import com.dh.catalogservice.service.ServiceMovie;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MovieListener {

    @Autowired
    private ServiceMovie ServiceMovie;

    public MovieListener(com.dh.catalogservice.service.ServiceMovie serviceMovie) {
        ServiceMovie = serviceMovie;
    }

    @RabbitListener(queues = {"${queue.movie.name}"})
    public void receive(@Payload MovieMongoDTO movie) {
        System.out.println("SI LLEGA EL MENSAJE DE MOVIE: " + movie);
        ServiceMovie.saveMovies(movie);
    }

}
