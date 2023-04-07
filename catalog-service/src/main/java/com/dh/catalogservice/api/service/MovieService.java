package com.dh.catalogservice.api.service;

import com.dh.catalogservice.api.repository.CatalogRepositoryMovies;
import com.dh.catalogservice.domain.model.MovieCatalogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOptions;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.lookup;

@Service
public class MovieService {
    @Autowired
    private CatalogRepositoryMovies CatalogRepositoryMovies;

    public List<MovieCatalogo> buscarPorGenero(String genre){

        return CatalogRepositoryMovies.findAllByGenre(genre);
    }


}


