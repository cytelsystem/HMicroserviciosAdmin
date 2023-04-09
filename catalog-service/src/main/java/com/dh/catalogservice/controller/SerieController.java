package com.dh.catalogservice.controller;

import com.dh.catalogservice.clienteFein.InterfaceSerieFein;
import com.dh.catalogservice.queue.SerieListener;
import com.dh.catalogservice.service.ServiceSerie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dh.catalogservice.model.SerieDTO;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class SerieController {

    @Autowired
    private InterfaceSerieFein interfaceSerie;

    @Autowired
    private SerieListener SerieListener;

    @Autowired
    private ServiceSerie ServiceSerie;

    //*****************************************************************************************************//

    @GetMapping("/series/{genre}")
    public List<SerieDTO> getSerieByGenre(@PathVariable String genre) {

        return interfaceSerie.getSerieByGenre(genre);
    }

    //*************************************Guardar mensajes Rabbi******************************************//

    @PostMapping("/salvar")
    public ResponseEntity<SerieDTO> guardarSerie(@RequestBody SerieDTO serie) {
        SerieListener.receive(serie);
        return ResponseEntity.noContent().build();
    }

    //**********************************************************************************************//


}
