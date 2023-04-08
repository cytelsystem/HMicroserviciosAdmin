package com.dh.catalogservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.dh.catalogservice.model.SerieFeinDTO;

import java.util.List;
@Repository
public interface LocalRepositorySeries extends MongoRepository<SerieFeinDTO, Long > {
    List<SerieFeinDTO> findAllByGenre(String genre);
}

