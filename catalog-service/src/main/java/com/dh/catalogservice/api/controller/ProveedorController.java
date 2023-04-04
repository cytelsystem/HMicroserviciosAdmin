package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.client.IProveedorService;
import com.dh.catalogservice.api.client.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProveedorController {

    @Autowired
    private IProveedorService interfaceProveedor;

    @GetMapping("saludarproveedor")
    public ResponseEntity<String> find() {

        return ResponseEntity.ok(interfaceProveedor.getSaludarProveedor());
    }


}
