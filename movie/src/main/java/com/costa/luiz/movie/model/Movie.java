package com.costa.luiz.movie.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@NamedQuery(name = "Movie.findByNameAndYear",
        query = "select movie from Movie movie where movie.name = ?1 and movie.year = ?2")
public class Movie {

    @Id
    private String id;
    private String name;
    private String year;
}
