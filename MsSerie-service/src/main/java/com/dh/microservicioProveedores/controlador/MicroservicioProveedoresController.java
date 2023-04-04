package com.dh.microservicioProveedores.controlador;

import com.dh.microservicioProveedores.service.microservicioProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/")
public class MicroservicioProveedoresController {

    @Autowired
    private microservicioProveedoresService servicedatos;


    @GetMapping("/saludarproveedor")
    public String getSaludar() {
        return "Hola como estas saludo desde proveedores";
    }


}
