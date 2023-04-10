package com.dh.catalogservice.service;

import com.dh.catalogservice.clienteFein.InterfaceMovieFein;
import com.dh.catalogservice.model.MovieFeinDTO;
import com.dh.catalogservice.model.MovieMongoDTO;
import com.dh.catalogservice.repository.CircuitBreackerRepository;
import com.dh.catalogservice.repository.LocalRepositoryMovies;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ServiceMovie {

    @Autowired
    private CircuitBreackerRepository CircuitBreackerRepository;

    private final InterfaceMovieFein InterfaceMovieFein;
    @Autowired
    public ServiceMovie(com.dh.catalogservice.clienteFein.InterfaceMovieFein interfaceMovieFein) {
        InterfaceMovieFein = interfaceMovieFein;
    }

    @Autowired
    private LocalRepositoryMovies LocalRepositoryMovies;

    // *********************************Guardar DB Mongo Catalogo**********************************//
    public MovieMongoDTO saveMovies(MovieMongoDTO movie) {

        return LocalRepositoryMovies.save(movie);
    }
    //***********************************Buscar por Genero***************************************//

    public List<MovieMongoDTO> BuscarPorGeneroMovie(String genre) {

        return LocalRepositoryMovies.findAllByGenre(genre);
    }

    //***********************************Metodo Fein******************************************//

    public List<MovieFeinDTO> FeinBuscarPorGeneroMovie(String genre) {
        return InterfaceMovieFein.getMovieByGenre(genre);
    }

    //***********************************Metodo CircuitBreacker******************************************//

    public List<MovieFeinDTO> CBBuscarPorGeneroMovie(String genre, Boolean throwError) throws RuntimeException{
        if(throwError)
            throw new RuntimeException();
        return CircuitBreackerRepository.findByMovieGenre(genre);
    }


    //*********************************************************************************************//


}









