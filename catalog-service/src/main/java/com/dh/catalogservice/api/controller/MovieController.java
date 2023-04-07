package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.client.IMovieService;
import com.dh.catalogservice.api.service.MovieService;
import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.model.MovieCatalogo;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieController {

    @Autowired
    private IMovieService InterfaceMovieService;
    @Autowired
    private MovieService MovieService;
    @CircuitBreaker(name="movieCB",fallbackMethod = "fallback")
    @GetMapping("/{genre}")
    public ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
          return ResponseEntity.ok().body(InterfaceMovieService.getMovieByGenre(genre));
    }

    @GetMapping("/local/{genre}")
    public ResponseEntity<List<MovieCatalogo>> getMovieByGenreCatalogo(@PathVariable String genre) {
        return ResponseEntity.ok().body(MovieService.buscarPorGenero(genre));
    }


    private ResponseEntity<List<Movie>> fallback(@PathVariable String genre, RuntimeException e) {
          return new ResponseEntity("Base de datos no funciona", HttpStatus.OK);
    }



}
