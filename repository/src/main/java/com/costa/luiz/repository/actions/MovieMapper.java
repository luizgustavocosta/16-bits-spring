package com.costa.luiz.repository.actions;

import com.costa.luiz.repository.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    MovieRequest map(Movie movie);
}