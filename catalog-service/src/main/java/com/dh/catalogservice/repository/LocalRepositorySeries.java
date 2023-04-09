package com.dh.catalogservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.dh.catalogservice.model.SerieDTO;

import java.util.List;
@Repository
public interface LocalRepositorySeries extends MongoRepository<SerieDTO, Long > {
    List<SerieDTO> findAllByGenre(String genre);
}

