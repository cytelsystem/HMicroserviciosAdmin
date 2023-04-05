package com.dh.catalogservice.api.repository;

import com.dh.catalogservice.domain.model.MovieCatalogo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogRepositoryMovies extends MongoRepository<MovieCatalogo, Long > {
    List<MovieCatalogo> findAllByGenre(String genre);
}

