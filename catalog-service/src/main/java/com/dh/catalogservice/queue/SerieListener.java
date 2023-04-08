package com.dh.catalogservice.queue;

import com.dh.catalogservice.model.SerieFeinDTO;
import com.dh.catalogservice.service.ServiceSerie;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class SerieListener {

    @Autowired
    private ServiceSerie ServiceSerie;

    public SerieListener(com.dh.catalogservice.service.ServiceSerie serviceSerie) {
        ServiceSerie = serviceSerie;
    }

    @RabbitListener(queues = {"${queue.serie.name}"})
    public void receive(@Payload SerieFeinDTO serie) {
        System.out.println("SI LLEGA EL MENSAJE DE SERIE: " + serie);
        ServiceSerie.save(serie);
    }

}
