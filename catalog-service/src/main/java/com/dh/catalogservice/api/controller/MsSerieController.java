package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.client.IMsSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MsSerieController {

    @Autowired
    private IMsSerieService interfaceSerie;


    @GetMapping("/series/saludarserie")
    public ResponseEntity<String> SerieSaludar() {

        return ResponseEntity.ok(interfaceSerie.getSaludar());
    }

    @GetMapping("/series/datos")
    String getdatos(@RequestParam String nombre, @RequestParam String apellido) {
        return interfaceSerie.getdatos(nombre, apellido);
    }


}
