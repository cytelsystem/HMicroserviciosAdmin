package com.dh.catalogservice.service;

import com.dh.catalogservice.model.SerieDTO;
import com.dh.catalogservice.repository.LocalRepositorySeries;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ServiceSerie {

    @Autowired
    private LocalRepositorySeries LocalRepositorySeries;

    //*************************************Guardar en el Repositorio*************************************//

    public SerieDTO save(SerieDTO serie) {
        return LocalRepositorySeries.save(serie);
    }
    //*************************************Buscar por genero***************************************//

    public List<SerieDTO> BuscarPorGeneroSerie(String serie) {
        return LocalRepositorySeries.findAllByGenre(serie);
    }

    //*******************************************************************************************//



}
