package com.dh.catalogservice.repository;

import com.dh.catalogservice.model.LocalMovieDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalRepositoryMovies extends MongoRepository<LocalMovieDTO, Long > {
    List<LocalMovieDTO> findAllByGenre(String genre);
}

