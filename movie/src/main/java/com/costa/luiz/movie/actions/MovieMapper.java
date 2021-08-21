package com.costa.luiz.movie.actions;

import com.costa.luiz.movie.model.Movie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    //MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    MovieRequest map(Movie movie);
}