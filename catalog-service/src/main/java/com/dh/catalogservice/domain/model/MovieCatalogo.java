package com.dh.catalogservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Movies")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MovieCatalogo {


    private Long id;
    private String name;
    private String genre;
    private String urlStream;


}
