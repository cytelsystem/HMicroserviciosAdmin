package com.dh.serieservice.controller;

import com.dh.serieservice.service.SerieService;
import com.dh.serieservice.queue.SerieSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dh.serieservice.model.Serie;

import java.util.List;


@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService servicedatos;
    @Autowired
    private SerieSender SerieSender;


    //*****************************Constructor**********************************//


    public SerieController(SerieService serieService) {
        this.servicedatos = serieService;
    }

    //*******************************Lista all **************************************//

//    @GetMapping
//    public List<Serie> getAll() {
//        return servicedatos.getAll();
//    }



    //*******************************Guarda en la base de datos Movies Mysql********************//

//    @PostMapping("/save")
//    ResponseEntity<?> saveSerie(@RequestBody Serie serie) {
//        return ResponseEntity.ok().body(servicedatos.create(serie));
//    }

    //*******************************Estaba con el template*****************************//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public String create(@RequestBody Serie serie) {
//        servicedatos.create(serie);
//        return serie.getId();
//    }

    //*******************************Lista las series por genero*****************************//

    @GetMapping("/{genre}")
    public List<Serie> getSerieByGenre(@PathVariable String genre) {

        return servicedatos.getSeriesBygGenre(genre);
    }

    //*********************Guarda Registro local y envia mensaje a la cola de RabbiMQ*********//

    @PostMapping("/salvar")
    public ResponseEntity<?> savePersona(@RequestBody Serie serie) {
        SerieSender.send(serie);
        servicedatos.create(serie);
        return ResponseEntity.ok("Su registro se esta procesando");
    }

    //**************************************************************************************//


}
