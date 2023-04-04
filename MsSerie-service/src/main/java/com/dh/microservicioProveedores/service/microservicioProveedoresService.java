package com.dh.microservicioProveedores.service;

import org.springframework.stereotype.Service;

@Service
public class microservicioProveedoresService {

    private String nombreApellido;
    public String getNombres(String nombre, String apellido) {

        return "Hola Como estas :" + nombre + " " + apellido;
    }
}
