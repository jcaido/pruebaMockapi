package com.jcaido.pruebaMockapi.service;

import com.jcaido.pruebaMockapi.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final RestTemplate restTemplate;

    public List<UserDto> getAllUsers() {
        return null;
    }

    public void saveUser(UserDto user) {

    }

    public void updateUser(Integer id, UserDto user) {

    }

    public void deleteUser(Integer id) {

    }
}
