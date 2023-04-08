package com.dh.movieservice.service;

import com.dh.movieservice.model.Movie;
import com.dh.movieservice.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {

        this.repository = repository;
    }

//    public List<Movie> findByGenre(String genre) {
//        return repository.findByGenre(genre);
//    }
    public List<Movie> findByGenre(String genre) {

        return repository.findByGenre(genre);
    }

    public Movie save(Movie movie) {

        return repository.save(movie);
    }
}
