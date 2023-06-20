package com.example.bookmyshow.Controllers;

import com.example.bookmyshow.Dtos.RequestDtos.AddUserDto;
import com.example.bookmyshow.Dtos.ResponseDtos.UserResponseDto;
import com.example.bookmyshow.Models.User;
import com.example.bookmyshow.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add-user")
    public ResponseEntity<String> addUser(@RequestBody AddUserDto addUserDto) {

        try {
            String response = userService.addUser(addUserDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CREATED);
        }

    }

    @GetMapping("/get-oldest-user")
    public ResponseEntity<?> getOldestUser() {
        try{
            UserResponseDto user = userService.getOldestUser();
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CREATED);
        }
    }

    @GetMapping("/find-users-greater-than-a-age")
    public ResponseEntity<?> getUsersGreaterThanAAge(@RequestParam("age") int age) {
        try{
            List<User> user = userService.getUsersGreaterThanAAge(age);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CREATED);
        }
    }
}
