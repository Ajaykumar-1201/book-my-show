package com.example.bookmyshow.Services;

import com.example.bookmyshow.Dtos.RequestDtos.AddUserDto;
import com.example.bookmyshow.Dtos.ResponseDtos.UserResponseDto;
import com.example.bookmyshow.Exceptions.UserTableEmptyException;
import com.example.bookmyshow.Models.User;
import com.example.bookmyshow.Repository.UserRepository;
import com.example.bookmyshow.Transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(AddUserDto addUserDto) {

        User user = UserTransformer.convertDtoToEntity(addUserDto);

        userRepository.save(user);

        return "User has been added to the database";
    }

    public UserResponseDto getOldestUser() throws UserTableEmptyException{

        List<User> userList = userRepository.findAll();

        User userAns = null;
        int max = 0;

        for(User user : userList) {
            if(max < user.getAge()) {
                max = user.getAge();
                userAns = user;
            }
        }
        if(userAns == null) {
            throw new UserTableEmptyException("Table is Empty");
        }

        UserResponseDto responseDto = UserTransformer.convertEntityToDto(userAns);

        return responseDto;
    }

    public List<User> getUsersGreaterThanAAge(int age) {
        List<User> userList = userRepository.findUserAgeGreaterThan(age);
        return userList;
    }
}
