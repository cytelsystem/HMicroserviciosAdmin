package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.client.IMsSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dh.catalogservice.domain.model.Serie;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class SerieController {

    @Autowired
    private IMsSerieService interfaceSerie;



    @GetMapping("/series/{genre}")
    public List<Serie> getSerieByGenre(@PathVariable String genre) {

        return interfaceSerie.getSerieByGenre(genre);
    }


}
