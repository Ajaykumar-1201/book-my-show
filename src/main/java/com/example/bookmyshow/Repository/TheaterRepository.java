package com.example.bookmyshow.Repository;

import com.example.bookmyshow.Models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {

    public Theater findByLocation(String location);
            //public Doctor findByEmailId(String emailId);
}
