package com.dh.serieservice.service;

import org.springframework.stereotype.Service;
import com.example.serieservice.model.Serie;
import com.example.serieservice.repository.SerieRepository;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class SerieService {

    private final SerieRepository repository;
    private String nombreApellido;

    public String getNombres(String nombre, String apellido) {

        return "Hola Como estas :" + nombre + " " + apellido;
    }


    public SerieService(SerieRepository repository) {
        this.repository = repository;
    }

    public List<Serie> getAll() {
        return repository.findAll();
    }

    public List<Serie> getSeriesBygGenre(String genre) {

        return repository.findAllByGenre(genre);
    }

    public String create(Serie serie) {
        repository.save(serie);
        return serie.getId();
    }



}
