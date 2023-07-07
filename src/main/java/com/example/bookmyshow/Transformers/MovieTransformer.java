package com.example.bookmyshow.Transformers;

import com.example.bookmyshow.Dtos.RequestDtos.AddMovieDto;
import com.example.bookmyshow.Models.Movie;

public class MovieTransformer {

    public static Movie convertDtoToEntity(AddMovieDto movieDto) {

        return Movie.builder()
                .movieName(movieDto.getMovieName())
                .genre(movieDto.getGenre())
                .duration(movieDto.getDuration())
                .rating(movieDto.getRating())
                .releaseDate(movieDto.getReleaseDate())
                .language(movieDto.getLanguage())
                .build();
    }
}
