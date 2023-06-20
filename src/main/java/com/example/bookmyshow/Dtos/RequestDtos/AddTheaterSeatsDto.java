package com.example.bookmyshow.Dtos.RequestDtos;

import lombok.Data;

@Data
public class AddTheaterSeatsDto {

    private int noOfSeatsInOneRow;

    private int noOfClassicSeats;

    private int noOfPremiumSeats;

    private String location;

}
