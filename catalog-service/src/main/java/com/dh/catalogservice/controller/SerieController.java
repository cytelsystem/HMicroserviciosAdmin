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
    private SerieListener SerieListener;

    @Autowired
    private ServiceSerie ServiceSerie;

    //******************************Guardar el mensaje que viene de la cola(Rabbi)*************************//

    @PostMapping("/salvarSerie")
    public ResponseEntity<SerieDTO> guardarSerie(@RequestBody SerieDTO serie) {
        SerieListener.receive(serie);
        return ResponseEntity.noContent().build();
    }

    //**************************************Metodo Fein parcial consultar Series***************************//

//    @GetMapping("/series/{genre}")
//    public List<SerieDTO> getSerieByGenre(@PathVariable String genre) {
//
//        return ServiceSerie.FeinBuscarPorGeneroSerie(genre);
//    }


    //**********************************************************************************************//



}
