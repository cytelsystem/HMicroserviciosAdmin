package com.dh.catalogservice.repository;

import com.dh.catalogservice.clienteFein.InterfaceMovieFein;
import com.dh.catalogservice.model.MovieFeinDTO;
import com.dh.catalogservice.model.MovieMongoDTO;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public class CircuitBreackerRepository {

    @Autowired
    private InterfaceMovieFein InterfaceMovieFein;

    @Autowired
    private LocalRepositoryMovies LocalRepositoryMovies;

     public CircuitBreackerRepository(com.dh.catalogservice.clienteFein.InterfaceMovieFein interfaceMovieFein) {
        InterfaceMovieFein = interfaceMovieFein;
    }

    @CircuitBreaker(name="movieCB",fallbackMethod = "fallback")
    @Retry(name = "movieCB")
    public List<MovieMongoDTO> findByMovieGenre(String genre) {
        System.out.println("Ejecutando...");
        List<MovieMongoDTO> response = InterfaceMovieFein.getMovieByGenre(genre);
        return response;
    }

//    public List<MovieFeinDTO> fallback(String genre, CallNotPermittedException exception) {
//        return Collections.singletonList(new MovieFeinDTO(1L, "prueba", genre, "ddasdsadas"));
//
//    }
//
    public List<MovieMongoDTO> fallback(String genre, CallNotPermittedException exception) {
        System.out.println("Ejecutando...CircuitBreacker Base Datos Mongo Movies");
        List<MovieMongoDTO> alternativa = LocalRepositoryMovies.findAllByGenre(genre);
        return alternativa;

    }


//    private ResponseEntity<List<MovieFeinDTO>> fallback(@PathVariable String genre, RuntimeException e) {
//          return new ResponseEntity("Base de datos no funciona", HttpStatus.OK);
//    }

//    private void fallback(CallNotPermittedException ex) throws CircuitBreakerException {
//        throw new CircuitBreakerException("Circuit breaker was activated");
//    }

//    public ResponseEntity<?> fallback(String genre, CallNotPermittedException exception) {
//        System.out.println("Ejecutando... Entro en la epcepcion");
//        return ResponseEntity.ok("dsadsada");
//
//    }







}



