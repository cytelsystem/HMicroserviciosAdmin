package com.dh.catalogservice.service;

import com.dh.catalogservice.clienteFein.InterfaceMovieFein;
import com.dh.catalogservice.model.MovieMongoDTO;
import com.dh.catalogservice.model.SerieFeinDTO;
import com.dh.catalogservice.repository.LocalRepositoryMovies;
import com.dh.catalogservice.model.LocalMovieDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ServiceMovie {
    @Autowired
    private InterfaceMovieFein InterfaceMovieFein;
    @Autowired
    private LocalRepositoryMovies LocalRepositoryMovies;

    public ServiceMovie(com.dh.catalogservice.repository.LocalRepositoryMovies localRepositoryMovies) {
        LocalRepositoryMovies = localRepositoryMovies;
    }

    public List<MovieMongoDTO> buscarPorGenero(String genre){

        return LocalRepositoryMovies.findAllByGenre(genre);
    }

//    public List<MovieFeinDTO> getMovieFeinGenre(String genre) {
//        return InterfaceMovieFein.getMovieByGenre(genre);
//    }

    public List<MovieMongoDTO> getMovieFeinGenre(String genre) {

        return LocalRepositoryMovies.findAllByGenre(genre);
    }


    // *********************************Guardar DB mongo Catalogo**********************************//
    public MovieMongoDTO saveMovies(MovieMongoDTO movie) {

        return LocalRepositoryMovies.save(movie);
    }
    //*********************************************************************************************//


}


