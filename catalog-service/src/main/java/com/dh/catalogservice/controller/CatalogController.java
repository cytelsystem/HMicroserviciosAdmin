package com.dh.catalogservice.controller;

import com.dh.catalogservice.service.ServiceCatalogoColas;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final ServiceCatalogoColas service;

    public CatalogController(ServiceCatalogoColas service) {
        this.service = service;
    }


}
