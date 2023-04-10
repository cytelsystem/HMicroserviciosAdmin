package com.dh.catalogservice.clienteFein;


import com.dh.catalogservice.configuration.CustomLoadBalancerConfiguration;
import com.dh.catalogservice.model.MovieFeinDTO;
import com.dh.catalogservice.model.MovieMongoDTO;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("movie-service")
@LoadBalancerClient(name = "movie-service", configuration = CustomLoadBalancerConfiguration.class )
public interface InterfaceMovieFein {

//    @GetMapping("/movies/{genre}")
//    List<MovieFeinDTO> getMovieByGenre(@PathVariable String genre);


    @RequestMapping(method = RequestMethod.GET, value = "/movies/{genre}")
    List<MovieMongoDTO> getMovieByGenre(@PathVariable String genre);


}
