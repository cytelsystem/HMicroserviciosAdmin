package com.dh.MsSerieService.service;

import org.springframework.stereotype.Service;

@Service
public class MsSerieService {

    private String nombreApellido;
    public String getNombres(String nombre, String apellido) {

        return "Hola Como estas :" + nombre + " " + apellido;
    }
}
