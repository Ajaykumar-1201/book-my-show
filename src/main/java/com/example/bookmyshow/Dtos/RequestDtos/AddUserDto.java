package com.example.bookmyshow.Dtos.RequestDtos;

import lombok.Data;

@Data
public class AddUserDto {
    private String name;

    private int age;

    private String mobileNo;

    private String emailId;
}
