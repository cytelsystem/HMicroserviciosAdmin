package com.dh.MsSerieService.controlador;

import com.dh.MsSerieService.service.MsSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/")
public class MsSerieController {

    @Autowired
    private MsSerieService servicedatos;


    @GetMapping("/saludarserie")
    public String getSaludar() {
        return "Hola como estas saludo desde serie";
    }


}
