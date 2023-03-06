package com.dh.apiGateway.service;

import org.springframework.stereotype.Service;

@Service
public class apiGatewayService {

    private String nombreApellido;
    public String getNombres(String nombre, String apellido) {

        return "Hola Como estas :" + nombre + " " + apellido;
    }
}
