package com.dh.climaservice.controlador;

import com.dh.climaservice.service.ClimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class ClimaController {

    @Autowired
    private ClimaService climaService;

    @GetMapping
    public Integer getTemperatura(@RequestParam String city, @RequestParam String country) {
        return climaService.getTemperatura(city, country);
    }
}
