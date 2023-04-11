package com.dh.catalogservice.controller;

import com.dh.catalogservice.model.CatalogoDTO;
import com.dh.catalogservice.model.MovieMongoDTO;
import com.dh.catalogservice.model.SerieDTO;
import com.dh.catalogservice.service.ServiceMovie;
import com.dh.catalogservice.service.ServiceSerie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogoController {

    @Autowired
    private ServiceMovie ServiceMovie;
    @Autowired
    private ServiceSerie ServiceSerie;

    //********************Consulta Base de datos Local Mongo Por Movie y Serie***************//

//    @GetMapping("/{genre}")
//    ResponseEntity<CatalogoDTO>  GetDataMongo(@PathVariable String genre) {
//        List<MovieMongoDTO> movies = ServiceMovie.BuscarPorGeneroMovie(genre);
//          List<SerieDTO> series = ServiceSerie.BuscarPorGeneroSerie(genre);
//          CatalogoDTO productos = new CatalogoDTO(genre, movies, series);
//
//        return ResponseEntity.ok(productos);
//    }


    //********************Consulta Base de datos Local Mongo Por Movie y Serie con CircuitBreacker***************//
    @GetMapping("/{genre}")
    ResponseEntity<CatalogoDTO>  GetDataMongo(@PathVariable String genre, @RequestParam(defaultValue = "false") Boolean throwError, HttpServletResponse response) {
        List<MovieMongoDTO> movies = ServiceMovie.CBBuscarPorGeneroMovie(genre,throwError);
        List<SerieDTO> series = ServiceSerie.BuscarPorGeneroSerie(genre);
        CatalogoDTO productos = new CatalogoDTO(genre, movies, series);

        return ResponseEntity.ok(productos);
    }

    //****************************************************************************************//



}
