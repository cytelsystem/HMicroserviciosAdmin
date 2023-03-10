package com.dh.catalogservice.api.client;


import com.dh.catalogservice.api.configuration.CustomLoadBalancerConfiguration;
import com.dh.catalogservice.domain.model.Movie;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("movie-service")
@LoadBalancerClient(name = "movie-service", configuration = CustomLoadBalancerConfiguration.class )
public interface IMovieService {

    @GetMapping("/movies/{genre}")
    List<Movie> getMovieByGenre(@PathVariable String genre);


}
