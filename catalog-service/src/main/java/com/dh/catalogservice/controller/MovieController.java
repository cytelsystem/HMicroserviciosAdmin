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
    private ServiceMovie ServiceMovie;

    @Autowired
    private MovieListener MovieListener;


    //******************************Guardar el mensaje que viene de la cola(Rabbi)*************************//
    @PostMapping("/salvarMovie")
    public ResponseEntity<MovieMongoDTO> guardarMovie(@RequestBody MovieMongoDTO movie) {
        MovieListener.receive(movie);
        return ResponseEntity.noContent().build();
    }

    //**************************************Metodo Fein parcial consultar movies***************************//
//    @GetMapping(value = "/feinMovies/{genre}")
//    public ResponseEntity<List<MovieMongoDTO>> getFeinMovieByGenre(@PathVariable String genre) {
//        return ResponseEntity.ok().body(MovieService.FeinBuscarPorGeneroMovie(genre));
//    }
    //********************************************Metodo CircuitBreacker Movies******************************//

    @GetMapping("/movies/{genre}")
    public ResponseEntity<List<MovieMongoDTO>> getCircuitBreackerMovieByGenre(@PathVariable String genre, @RequestParam(defaultValue = "false") Boolean throwError, HttpServletResponse response) {
        return ResponseEntity.ok().body(ServiceMovie.CBBuscarPorGeneroMovie(genre,throwError));
    }

    //******************************************************************************************************//


}
