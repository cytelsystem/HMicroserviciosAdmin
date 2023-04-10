package com.dh.catalogservice.controller;

import com.dh.catalogservice.clienteFein.InterfaceMovieFein;
import com.dh.catalogservice.model.MovieMongoDTO;
import com.dh.catalogservice.queue.MovieListener;
import com.dh.catalogservice.service.ServiceMovie;
import com.dh.catalogservice.model.MovieFeinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieController {

    @Autowired
    private InterfaceMovieFein IMovieServiceFein;
    @Autowired
    private ServiceMovie MovieService;

    @Autowired
    private MovieListener MovieListener;

    //**************************************CircuitBreacker******************************************//

//    @CircuitBreaker(name="movieCB",fallbackMethod = "fallback")
//    @GetMapping("/circuitbreacker/{genre}")
//    public ResponseEntity<List<MovieFeinDTO>> getMovieByGenre(@PathVariable String genre) {
//          return ResponseEntity.ok().body(IMovieServiceFein.getMovieByGenre(genre));
//    }


//    private ResponseEntity<List<MovieFeinDTO>> fallback(@PathVariable String genre, RuntimeException e) {
//          return new ResponseEntity("Base de datos no funciona", HttpStatus.OK);
//    }

    //*********************************************************************************************************//

//    @GetMapping("/genreFein/{genre}")
//    public ResponseEntity<List<MovieFeinDTO>> getMovieFeinGenre(@PathVariable String genre) {
//        return (ResponseEntity<List<MovieFeinDTO>>) MovieService.getMovieFeinGenre(genre);
//    }

    //*************************************Guardar mensajes Rabbi******************************************//
    @PostMapping("/salvarMovie")
    public ResponseEntity<MovieMongoDTO> guardarMovie(@RequestBody MovieMongoDTO movie) {
        MovieListener.receive(movie);
        return ResponseEntity.noContent().build();
    }

    //*****************************************Metodo Fein*********************************************//
    @GetMapping(value = "/fein/{genre}")
    public ResponseEntity<List<MovieFeinDTO>> getFeinMovieByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(MovieService.FeinBuscarPorGeneroMovie(genre));
    }
    //******************************************************************************************************//

    @GetMapping("/circuitbreacker/{genre}")
    public ResponseEntity<List<MovieFeinDTO>> getCircuitBreackerMovieByGenre(@PathVariable String genre, @RequestParam(defaultValue = "false") Boolean throwError, HttpServletResponse response) {
        return ResponseEntity.ok().body(MovieService.CBBuscarPorGeneroMovie(genre,throwError));
    }

    //******************************************************************************************************//


}
