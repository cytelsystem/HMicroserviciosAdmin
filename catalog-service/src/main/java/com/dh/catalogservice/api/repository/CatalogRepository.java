package com.dh.catalogservice.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.dh.catalogservice.domain.model.Serie;

import java.util.List;
@Repository
public interface CatalogRepository extends MongoRepository<Serie, Long> {
    List<Serie> findAllByGenre(String genre);
}
