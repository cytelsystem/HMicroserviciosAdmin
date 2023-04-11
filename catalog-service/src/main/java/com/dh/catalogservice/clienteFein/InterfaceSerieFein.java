package com.dh.catalogservice.clienteFein;


import com.dh.catalogservice.configuration.CustomLoadBalancerConfiguration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.dh.catalogservice.model.SerieDTO;

import java.util.List;


@FeignClient("serie-service")
@LoadBalancerClient(name = "serie-service", configuration = CustomLoadBalancerConfiguration.class )
public interface InterfaceSerieFein {

//    @GetMapping("/series/{genre}")
//    List<SerieDTO> getSerieByGenre(@PathVariable String genre);

    @RequestMapping(method = RequestMethod.GET, value = "/series/{genre}")
    List<SerieDTO> getSerieByGenre(@PathVariable String genre);

}
