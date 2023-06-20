package com.example.bookmyshow.Transformers;

import com.example.bookmyshow.Dtos.RequestDtos.AddUserDto;
import com.example.bookmyshow.Dtos.ResponseDtos.UserResponseDto;
import com.example.bookmyshow.Models.User;

public class UserTransformer {

    public static User convertDtoToEntity(AddUserDto userDto) {

        //using builder
        User user = User.builder()
                .age(userDto.getAge())
                .name(userDto.getName())
                .emailId(userDto.getEmailId())
                .mobileNo(userDto.getMobileNo())
                .build();

        return user;
    }

    public static UserResponseDto convertEntityToDto(User user) {
        UserResponseDto responseDto = UserResponseDto.builder()
                .age(user.getAge())
                .mobileNo(user.getMobileNo())
                .name(user.getName())
                .build();

        return responseDto;
    }
}
