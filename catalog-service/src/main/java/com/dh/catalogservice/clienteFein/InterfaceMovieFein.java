package com.dh.catalogservice.clienteFein;


import com.dh.catalogservice.configuration.CustomLoadBalancerConfiguration;
import com.dh.catalogservice.model.MovieFeinDTO;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("movie-service")
@LoadBalancerClient(name = "movie-service", configuration = CustomLoadBalancerConfiguration.class )
public interface InterfaceMovieFein {

    @GetMapping("/movies/{genre}")
    List<MovieFeinDTO> getMovieByGenre(@PathVariable String genre);


}
