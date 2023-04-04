package com.dh.serieService.controlador;

import com.dh.serieService.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/")
public class SerieController {

    @Autowired
    private SerieService servicedatos;


    @GetMapping("/saludarserie")
    public String getSaludarSerie() {

        return "Hola como estas saludo desde serie";
    }


}
