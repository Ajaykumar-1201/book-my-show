package com.example.bookmyshow.Repository;

//import com.example.bookmyshowJune.Models.Ticket;
//import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookmyshow.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}

