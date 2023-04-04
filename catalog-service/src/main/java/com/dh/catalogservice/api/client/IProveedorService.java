package com.dh.catalogservice.api.client;


import com.dh.catalogservice.api.configuration.CustomLoadBalancerConfiguration;
import com.dh.catalogservice.domain.model.Movie;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("proveedores-service")
@LoadBalancerClient(name = "proveedores-service", configuration = CustomLoadBalancerConfiguration.class )
public interface IProveedorService {

    @GetMapping("/saludarproveedor")
    String getSaludarProveedor();


}
