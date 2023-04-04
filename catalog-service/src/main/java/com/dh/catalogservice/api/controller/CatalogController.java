package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.client.IMovieService;
import com.dh.catalogservice.api.client.IMsSerieService;
import com.dh.catalogservice.domain.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private IMovieService MovieService;
    private IMsSerieService SerieService;



//    private final CatalogService service;

//    public CatalogController(CatalogService service) {
//        this.service = service;
//    }
//

//    @GetMapping("/{genre}")
//    ResponseEntity<List<Movie>> getGenre(@PathVariable String genre) {
//
//        return ResponseEntity.ok().body(service.getMovieByGenre(genre));
//    }

//    @GetMapping("/{genre}")
//    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
//        return ResponseEntity.ok().body(service.findByGenre(genre));
//    }

    @GetMapping("/prueba")
    public String prueba(){
        return "hola microservicio Catalogo responde";
    }



//    @GetMapping("/{genre}")
//    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
//        return ResponseEntity.ok().body(MovieService.getMovieByGenre(genre));
//    }
    @GetMapping("/{genre}")
    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
          return ResponseEntity.ok().body(MovieService.getMovieByGenre(genre));
    }
//    @GetMapping("serie/{genre}")
//    ResponseEntity<List<Serie>> getSerieByGenre(@PathVariable String genre) {
//          return ResponseEntity.ok().body(SerieService.getSerieByGenre(genre));
//    }



}
