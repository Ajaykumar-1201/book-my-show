package com.example.bookmyshow.Dtos.RequestDtos;

import com.example.bookmyshow.Enums.Genre;
import com.example.bookmyshow.Enums.Language;
import lombok.Data;

import java.util.Date;

@Data
public class AddMovieDto {

    private String movieName; // movie name cannot be null

    private String duration;

    private String rating;

    private Date releaseDate;

    private Genre genre;

    private Language language;
}

