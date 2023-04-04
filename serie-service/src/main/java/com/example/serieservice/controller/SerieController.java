package com.example.serieservice.controller;


import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/")
public class SerieController {

    @GetMapping("serieprueba")
    public String seriePrueba(){

        return "hola microservicio serieService responde";
    }

}
