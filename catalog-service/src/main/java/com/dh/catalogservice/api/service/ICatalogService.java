package com.dh.catalogservice.api.service;

import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.model.Serie;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface ICatalogService {
    List<Serie> getSerieByGenre (String genre);
    List<Movie> getMovieByGenre (String genre);

}
