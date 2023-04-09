package com.dh.catalogservice.controller;

import com.dh.catalogservice.model.CatalogoDTO;
import com.dh.catalogservice.model.MovieMongoDTO;
import com.dh.catalogservice.model.SerieDTO;
import com.dh.catalogservice.service.ServiceMovie;
import com.dh.catalogservice.service.ServiceSerie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogoController {

    @Autowired
    private ServiceMovie ServiceMovie;
    @Autowired
    private ServiceSerie ServiceSerie;



    @GetMapping("/{genre}")
    ResponseEntity<CatalogoDTO>  GetDataMongo(@PathVariable String genre) {
        List<MovieMongoDTO> movies = ServiceMovie.BuscarPorGeneroMovie(genre);
          List<SerieDTO> series = ServiceSerie.BuscarPorGeneroSerie(genre);
          CatalogoDTO productos = new CatalogoDTO(genre, movies, series);

        return ResponseEntity.ok(productos);
    }



}
