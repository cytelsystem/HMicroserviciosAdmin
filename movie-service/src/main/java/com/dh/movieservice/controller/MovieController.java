package com.dh.movieservice.controller;

import com.dh.movieservice.queue.MovieSender;
import com.dh.movieservice.service.MovieService;
import com.dh.movieservice.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService service;

    @Autowired
    private MovieSender MovieSender;

    //**********************************Constructor******************************************//

    public MovieController(MovieService service) {
        this.service = service;
    }


    //***************************Guarda en la base de datos Movies Mongo Serie****************//
//    @PostMapping("/save")
//    ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
//
//        return ResponseEntity.ok().body(service.save(movie));
//    }

    //*******************************Lista las Movies por genero*****************************//
    @GetMapping("/{genre}")
    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(service.findByGenre(genre));
    }

    //*********************Guarda Registro local y envia mensaje a la cola de RabbiMQ*********//
    @PostMapping("/salvar")
    public ResponseEntity<?> savePersona(@RequestBody Movie movie) {
        MovieSender.send(movie);
        service.save(movie);
        return ResponseEntity.ok("Su registro se esta procesando");
    }
    //**************************************************************************************//

}
