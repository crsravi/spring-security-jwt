package com.crs.controllers;

import com.crs.dto.UserDto;
import com.crs.models.User;
import com.crs.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services/controller/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<String> saveUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.saveDto(userDto), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }



    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user/{user-name}")
    public ResponseEntity<User> getUser(@PathVariable("user-name") String user) {
        return new ResponseEntity<>(userService.findUser(user), HttpStatus.OK);
    }

}
