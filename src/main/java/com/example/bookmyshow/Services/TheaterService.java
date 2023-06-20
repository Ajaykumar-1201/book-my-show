package com.example.bookmyshow.Services;

import com.example.bookmyshow.Dtos.RequestDtos.AddTheaterDto;
import com.example.bookmyshow.Dtos.RequestDtos.AddTheaterSeatsDto;
import com.example.bookmyshow.Enums.SeatType;
import com.example.bookmyshow.Models.Theater;
import com.example.bookmyshow.Models.TheaterSeat;
import com.example.bookmyshow.Repository.TheaterRepository;
import com.example.bookmyshow.Transformers.TheaterTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterService {

    @Autowired
    TheaterRepository theaterRepository;
    public String addTheater(AddTheaterDto theaterDto) {
        Theater theater = TheaterTransformers.convertDtoToEntity(theaterDto);

        theaterRepository.save(theater);

        return "Theater has been added to database";
    }

    public String addTheaterSeats(AddTheaterSeatsDto theaterSeatsDto) {
        //We need to save the TheaterSeat Entity

        int col = theaterSeatsDto.getNoOfSeatsInOneRow();

        int noOfClassicSeats = theaterSeatsDto.getNoOfClassicSeats();

        int noOfPremiumSeats = theaterSeatsDto.getNoOfPremiumSeats();

        String location = theaterSeatsDto.getLocation();

        Theater theater = theaterRepository.findByLocation(location);

        //create a lot of

        int counter = 1;
        int columnCount = 1;
        char ch = 'A';


        for(int i = 1; i <= noOfClassicSeats; i++) {
            TheaterSeat theaterSeat = new TheaterSeat();

            if(columnCount == col + 1) {
                columnCount = 1;
                counter++;
                ch = 'A';
            }

            String seatNo = String.valueOf(counter);
            seatNo += ch;
            ch++;
            columnCount++;

            //If no of col is greater than 26
//            if(ch == 'Z') {
//                ch = 'A';
//            } else {
//                ch++;
//            }

            theaterSeat.setSeatNo(seatNo);
            theaterSeat.setTheater(theater);
            theaterSeat.setSeatType(SeatType.CLASSIC);
            theater.getTheaterSeatList().add(theaterSeat);

        }

//        counter = 1;
//        columnCount = 1;
//        ch = 'A';

        for(int i = 1; i <= noOfPremiumSeats; i++) {
            TheaterSeat theaterSeat = new TheaterSeat();

            if(columnCount == col + 1) {
                columnCount = 1;
                counter++;
                ch = 'A';
            }

            String seatNo = String.valueOf(counter);
            seatNo += ch;
            ch++;
            columnCount++;

//            if(ch == 'Z') {
//                ch = 'A';
//            } else {
//                ch++;
//            }

            theaterSeat.setSeatNo(seatNo);
            theaterSeat.setTheater(theater);
            theaterSeat.setSeatType(SeatType.PREMIUM);
            theater.getTheaterSeatList().add(theaterSeat);

        }
        //We just need to save the parent
        //child will be automatically saved;
        theaterRepository.save(theater);

        return "Theater Seats have been allocated to the theater";
    }
}
