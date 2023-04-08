package com.dh.catalogservice.controller;

import com.dh.catalogservice.clienteFein.InterfaceSerieFein;
import com.dh.catalogservice.queue.SerieListener;
import com.dh.catalogservice.service.ServiceSerie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dh.catalogservice.model.SerieFeinDTO;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class SerieController {

    @Autowired
    private InterfaceSerieFein interfaceSerie;

    @Autowired
    private SerieListener listener;

    @Autowired
    private ServiceSerie ServiceSerie;



    @GetMapping("/series/{genre}")
    public List<SerieFeinDTO> getSerieByGenre(@PathVariable String genre) {

        return interfaceSerie.getSerieByGenre(genre);
    }


    @PostMapping("/salvarSerie")
    public ResponseEntity<SerieFeinDTO> guardarSeriedb(@RequestBody SerieFeinDTO serie) {
        ServiceSerie.save(serie);
        return ResponseEntity.noContent().build();
    }

//    @PostMapping("/salvar")
//    public ResponseEntity<SerieFeinDTO> guardarSerie(@RequestBody SerieFeinDTO serie) {
//        listener.receive(serie);
//        return ResponseEntity.noContent().build();
//    }


}
