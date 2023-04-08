package com.dh.catalogservice.service;

import com.dh.catalogservice.model.MovieFeinDTO;
import com.dh.catalogservice.model.SerieFeinDTO;

import java.util.List;

public interface ICatalogService {
    List<SerieFeinDTO> getSerieByGenre (String genre);
    List<MovieFeinDTO> getMovieByGenre (String genre);

}
