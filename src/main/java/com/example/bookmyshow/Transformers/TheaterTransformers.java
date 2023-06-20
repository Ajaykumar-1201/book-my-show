package com.example.bookmyshow.Transformers;

import com.example.bookmyshow.Dtos.RequestDtos.AddTheaterDto;
import com.example.bookmyshow.Models.Theater;

public class TheaterTransformers {

    public static Theater convertDtoToEntity(AddTheaterDto theaterDto) {
        Theater theater = Theater.builder()
                .location(theaterDto.getLocation())
                .name(theaterDto.getName())
                .build();

        return theater;
    }
}
