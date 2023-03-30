package com.dh.catalogservice.api.client;


import com.dh.catalogservice.api.configuration.CustomLoadBalancerConfiguration;
import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.model.Serie;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("serie-service")
@LoadBalancerClient(name = "serie-service", configuration = CustomLoadBalancerConfiguration.class )
public interface ISerieService {

    @GetMapping("/series/{genre}")
    List<Serie> getSerieByGenre(@PathVariable String genre);


}
