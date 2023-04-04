package com.dh.serieservice.service;

import org.springframework.stereotype.Service;

@Service
public class SerieService {
    private String nombreApellido;
    public String getNombres(String nombre, String apellido) {

        return "Hola Como estas :" + nombre + " " + apellido;
    }
}
