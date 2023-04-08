package com.dh.catalogservice.service;

import com.dh.catalogservice.clienteFein.InterfaceMovieFein;
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
    private LocalRepositoryMovies CatalogRepositoryMovies;
    @Autowired
    private InterfaceMovieFein InterfaceMovieFein;
    @Autowired
    private LocalRepositoryMovies LocalRepositoryMovies;

    public ServiceMovie(com.dh.catalogservice.repository.LocalRepositoryMovies localRepositoryMovies) {
        LocalRepositoryMovies = localRepositoryMovies;
    }

    public List<LocalMovieDTO> buscarPorGenero(String genre){

        return CatalogRepositoryMovies.findAllByGenre(genre);
    }

//    public List<MovieFeinDTO> getMovieFeinGenre(String genre) {
//        return InterfaceMovieFein.getMovieByGenre(genre);
//    }

    public List<LocalMovieDTO> getMovieFeinGenre(String genre) {

        return LocalRepositoryMovies.findAllByGenre(genre);
    }

    //*********************************Guardar DB mongo Catalogo**********************************//
    public LocalMovieDTO save(LocalMovieDTO movie) {

        return LocalRepositoryMovies.save(movie);
    }
    //*********************************************************************************************//


}


