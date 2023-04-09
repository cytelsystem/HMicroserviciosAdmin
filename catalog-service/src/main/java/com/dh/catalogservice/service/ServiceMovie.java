package com.dh.catalogservice.service;

import com.dh.catalogservice.clienteFein.InterfaceMovieFein;
import com.dh.catalogservice.model.MovieMongoDTO;
import com.dh.catalogservice.repository.LocalRepositoryMovies;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ServiceMovie {
    @Autowired
    private InterfaceMovieFein InterfaceMovieFein;
    @Autowired
    private LocalRepositoryMovies LocalRepositoryMovies;

    // *********************************Guardar DB Mongo Catalogo**********************************//
    public MovieMongoDTO saveMovies(MovieMongoDTO movie) {

        return LocalRepositoryMovies.save(movie);
    }
    //***********************************Buscar por Genero*****************************//

    public List<MovieMongoDTO> BuscarPorGeneroMovie(String genre) {

        return LocalRepositoryMovies.findAllByGenre(genre);
    }

    //*********************************************************************************************//



}


