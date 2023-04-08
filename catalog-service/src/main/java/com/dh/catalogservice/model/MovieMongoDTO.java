package com.dh.catalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Movies")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MovieMongoDTO {

    private String id;
    private String name;
    private String genre;
    private String urlStream;


}
