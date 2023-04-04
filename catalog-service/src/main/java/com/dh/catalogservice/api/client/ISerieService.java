package com.dh.catalogservice.api.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient("serie-service")
public interface ISerieService {
    @GetMapping("/saludarserie")
    String getSaludarSerie();
}
