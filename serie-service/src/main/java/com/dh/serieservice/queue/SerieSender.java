package com.dh.serieservice.queue;

import com.dh.serieservice.model.Serie;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SerieSender {

    private final RabbitTemplate rabbitTemplate;

    private final Queue NewSerie;

    public void send(Serie serie) {
        this.rabbitTemplate.convertAndSend(this.NewSerie.getName(), serie);
    }


}
