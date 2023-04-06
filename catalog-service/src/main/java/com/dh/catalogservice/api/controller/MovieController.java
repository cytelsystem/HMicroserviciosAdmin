package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.client.IMovieService;
import com.dh.catalogservice.domain.model.Movie;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
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
    private IMovieService MovieService;

    @GetMapping("/{genre}")

    @CircuitBreaker(name="subscription",fallbackMethod = "subsciptionFallbackMethod")
    @Retry(name = "subscription")
    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
          return ResponseEntity.ok().body(MovieService.getMovieByGenre(genre));
    }

    private ResponseEntity<List<Movie>> subsciptionFallbackMethod(@PathVariable String genre) {
          return new ResponseEntity("Movies " + genre + "no existe", HttpStatus.OK);
    }


}
