package com.dh.catalogservice.service;

import com.dh.catalogservice.model.MovieFeinDTO;
import com.dh.catalogservice.model.SerieDTO;

import java.util.List;

public interface ICatalogService {
    List<SerieDTO> getSerieByGenre (String genre);
    List<MovieFeinDTO> getMovieByGenre (String genre);

}
