package com.example.bookmyshow.Controllers;

import com.example.bookmyshow.Dtos.RequestDtos.AddTheaterDto;
import com.example.bookmyshow.Dtos.RequestDtos.AddTheaterSeatsDto;
import com.example.bookmyshow.Models.Theater;
import com.example.bookmyshow.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @PostMapping("/add-theater")
    public ResponseEntity<?> addTheater(@RequestBody AddTheaterDto theaterDto) {
        try{
            String response = theaterService.addTheater(theaterDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CREATED);
        }
    }

    @PostMapping("/add-theater-seats")
    public ResponseEntity<?> addTheaterSeats(@RequestBody AddTheaterSeatsDto theaterSeatsDto) {
        try {
            String response = theaterService.addTheaterSeats(theaterSeatsDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.CREATED);
        }
    }
}
