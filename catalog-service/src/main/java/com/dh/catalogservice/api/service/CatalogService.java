package com.dh.catalogservice.api.service;


import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.model.Serie;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class CatalogService implements ICatalogService {


    private RestTemplate clienteRest;

    public CatalogService(RestTemplate clienteRest) {
        this.clienteRest = clienteRest;
    }

    @Override
    public List<Movie> getMovieByGenre(String genre) {

        var url = String.format("http://localhost:8001/movies/%s", genre);

        var response = clienteRest.exchange(url, HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Movie>>() {
                });

        return Objects.requireNonNull(response.getBody());
    }


    public List<Serie> getSerieByGenre(String genre) {

        var url = String.format("http://localhost:8001/series/%s", genre);

        var response = clienteRest.exchange(url, HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Serie>>() {
                });

        return Objects.requireNonNull(response.getBody());
    }



}
