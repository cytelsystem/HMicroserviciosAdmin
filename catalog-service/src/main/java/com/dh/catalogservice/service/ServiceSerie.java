package com.dh.catalogservice.service;

import com.dh.catalogservice.model.SerieFeinDTO;
import com.dh.catalogservice.repository.LocalRepositorySeries;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ServiceSerie {

    @Autowired
    private LocalRepositorySeries LocalRepositorySeries;

    public SerieFeinDTO save(SerieFeinDTO serie) {

        return LocalRepositorySeries.save(serie);
    }


}
