package com.dh.catalogservice.controller;

import com.dh.catalogservice.clienteFein.InterfaceSerieFein;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.dh.catalogservice.model.SerieFeinDTO;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class SerieController {

    @Autowired
    private InterfaceSerieFein interfaceSerie;



    @GetMapping("/series/{genre}")
    public List<SerieFeinDTO> getSerieByGenre(@PathVariable String genre) {

        return interfaceSerie.getSerieByGenre(genre);
    }


}
