package com.dh.microservicioInicial.service;

import org.springframework.stereotype.Service;

@Service
public class microservicioInicialService {

    private String nombreApellido;
    public String getNombres(String nombre, String apellido) {

        return "Hola Como estas :" + nombre + " " + apellido;
    }
}
