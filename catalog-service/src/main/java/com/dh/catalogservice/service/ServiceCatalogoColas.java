package com.dh.catalogservice.service;


import com.dh.catalogservice.model.MovieFeinDTO;
import com.dh.catalogservice.model.SerieFeinDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class ServiceCatalogoColas implements ICatalogService {


    private RestTemplate clienteRest;

    public ServiceCatalogoColas(RestTemplate clienteRest) {
        this.clienteRest = clienteRest;
    }

    @Override
    public List<MovieFeinDTO> getMovieByGenre(String genre) {

        var url = String.format("http://localhost:8001/movies/%s", genre);

        var response = clienteRest.exchange(url, HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MovieFeinDTO>>() {
                });

        return Objects.requireNonNull(response.getBody());
    }


    public List<SerieFeinDTO> getSerieByGenre(String genre) {

        var url = String.format("http://localhost:8001/series/%s", genre);

        var response = clienteRest.exchange(url, HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<SerieFeinDTO>>() {
                });

        return Objects.requireNonNull(response.getBody());
    }



}
