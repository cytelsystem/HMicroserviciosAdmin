package com.dh.microservicioInicial.controlador;

import com.dh.microservicioInicial.service.microservicioInicialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MicroservicioInicialController {

    @Autowired
    private microservicioInicialService servicedatos;

    @GetMapping
    public Integer getTemperatura(@RequestParam String nombre, @RequestParam String apellido) {
        return servicedatos.getNombres(nombre, apellido);
    }
}
