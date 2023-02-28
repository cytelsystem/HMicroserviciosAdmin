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
    public String microservicioFunciona() {
        return "Este microservicio esta funcionando";
    }

    @GetMapping("/datos")
    public String getdatos(@RequestParam String nombre, @RequestParam String apellido) {
        return servicedatos.getNombres(nombre, apellido);
    }
    @GetMapping("/saludar")
    public String getSaludar() {
        return "Hola como estas";
    }


}
