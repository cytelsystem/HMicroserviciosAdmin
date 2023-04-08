package com.dh.catalogservice.queue;

import com.dh.catalogservice.model.LocalMovieDTO;
import com.dh.catalogservice.model.MovieFeinDTO;
import com.dh.catalogservice.model.SerieFeinDTO;
import com.dh.catalogservice.service.ServiceMovie;
import com.dh.catalogservice.service.ServiceSerie;
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
    public void receive(@Payload LocalMovieDTO movie) {
        System.out.println("SI LLEGA EL MENSAJE DE SERIE: " + movie);
        ServiceMovie.save(movie);
    }

}
