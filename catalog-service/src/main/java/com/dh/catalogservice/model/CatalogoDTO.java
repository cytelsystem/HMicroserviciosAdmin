package com.dh.catalogservice.model;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class CatalogoDTO {


    private String genre;
    private List<MovieMongoDTO> movies;
    private List<SerieDTO> series;

    public CatalogoDTO(String genre, List<MovieMongoDTO> movies, List<SerieDTO> series) {
        this.genre = genre;
        this.movies = movies;
        this.series = series;
    }
}
