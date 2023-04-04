package com.dh.catalogservice.api.client;


import com.dh.catalogservice.api.configuration.CustomLoadBalancerConfiguration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("serie-service")
@LoadBalancerClient(name = "serie-service", configuration = CustomLoadBalancerConfiguration.class )
public interface IMsSerieService {
    @GetMapping("/series/saludarserie")
    String getSaludar();

    @GetMapping("/series/datos")
    String getdatos(@RequestParam String nombre, @RequestParam String apellido);

}
