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

    //***********************Guardar en la Base de datos Mongo Local Movies****************************//
    public MovieMongoDTO saveMovies(MovieMongoDTO movie) {

        return LocalRepositoryMovies.save(movie);
    }

    //******************************Buscar por genero local Movies************************************//

    public List<MovieMongoDTO> BuscarPorGeneroMovie(String genre) {

        return LocalRepositoryMovies.findAllByGenre(genre);
    }

    //****************************Metodo Fein a MicroServicio Movie**********************************//

    public List<MovieMongoDTO> FeinBuscarPorGeneroMovie(String genre) {
        return InterfaceMovieFein.getMovieByGenre(genre);
    }

    //***********************************Metodo CircuitBreacker****************************************//
    // Se dejo el Circuitbreacker conectado al microservicio de Movies en el cual se tiene como
    // alternativa de redundancia en caso de que falle un Get mostrar las películas de la base de datos local mongo local
    // las cuales estan siempre actualizadas utilizando el sistema RabbiMQ

    public List<MovieMongoDTO> CBBuscarPorGeneroMovie(String genre, Boolean throwError) throws RuntimeException{
        if(throwError)
            throw new RuntimeException();
        return CircuitBreackerRepository.findByMovieGenre(genre);
    }

    //**************************************************************************************************//


}









