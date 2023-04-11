package com.dh.catalogservice.service;

import com.dh.catalogservice.clienteFein.InterfaceSerieFein;
import com.dh.catalogservice.model.MovieMongoDTO;
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

    @Autowired
    private InterfaceSerieFein InterfaceSerieFein;

    //***********************Guardar en la Base de datos Mongo Local Serie****************************//

    public SerieDTO save(SerieDTO serie) {

        return LocalRepositorySeries.save(serie);

    }

    //******************************Buscar por genero local Serie************************************//

    public List<SerieDTO> BuscarPorGeneroSerie(String serie) {

        return LocalRepositorySeries.findAllByGenre(serie);

    }

    //****************************Metodo Fein a MicroServicio Serie**********************************//

    public List<SerieDTO> FeinBuscarPorGeneroSerie(String genre) {

        return InterfaceSerieFein.getSerieByGenre(genre);

    }

    //***********************************************************************************************//




}
