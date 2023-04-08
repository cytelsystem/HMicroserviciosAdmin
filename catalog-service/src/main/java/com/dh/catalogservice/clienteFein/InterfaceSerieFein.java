package com.dh.catalogservice.clienteFein;


import com.dh.catalogservice.configuration.CustomLoadBalancerConfiguration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.dh.catalogservice.model.SerieFeinDTO;

import java.util.List;


@FeignClient("serie-service")
@LoadBalancerClient(name = "serie-service", configuration = CustomLoadBalancerConfiguration.class )
public interface InterfaceSerieFein {
    @GetMapping("/series/saludarserie")
    String getSaludar();

    @GetMapping("/series/datos")
    String getdatos(@RequestParam String nombre, @RequestParam String apellido);

    @GetMapping("/series/{genre}")
    List<SerieFeinDTO> getSerieByGenre(@PathVariable String genre);

}
