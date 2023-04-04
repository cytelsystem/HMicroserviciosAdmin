package com.dh.catalogservice.api.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient("MsSerieService")
public interface IMsSerieService {
    @GetMapping("/saludarserie")
    String getSaludarSerie();
}
