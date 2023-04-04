package com.dh.serieservice.controller;

import com.dh.serieservice.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.serieservice.model.Serie;

import java.util.List;


@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService servicedatos;


    @GetMapping("/datos")
    public String getdatos(@RequestParam String nombre, @RequestParam String apellido) {
        return servicedatos.getNombres(nombre, apellido);
    }

    @GetMapping("/saludarserie")
    public String getSaludar() {
        return "Hola como estas saludo desde serie";
    }


    public SerieController(SerieService serieService) {
        this.servicedatos = serieService;
    }

    @GetMapping
    public List<Serie> getAll() {
        return servicedatos.getAll();
    }

    @GetMapping("/{genre}")
    public List<Serie> getSerieByGenre(@PathVariable String genre) {

        return servicedatos.getSeriesBygGenre(genre);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody Serie serie) {
        servicedatos.create(serie);
        return serie.getId();
    }




}
