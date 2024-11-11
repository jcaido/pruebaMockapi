package com.jcaido.pruebaMockapi.controller;

import com.jcaido.pruebaMockapi.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/users")
public class UserController {

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody UserDto user) {

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@PathVariable("id") Integer id, @RequestBody UserDto user) {

    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {

    }
}
