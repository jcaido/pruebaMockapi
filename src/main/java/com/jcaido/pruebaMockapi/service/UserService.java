package com.jcaido.pruebaMockapi.service;

import com.jcaido.pruebaMockapi.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final RestTemplate restTemplate;

    @Value("${spring.external.service.base-url}")
    private String basePath;

    public List<UserDto> getAllUsers() {

        UserDto[] users = restTemplate.getForObject(basePath + "/users", UserDto[].class);

        return Arrays.asList(users);
    }

    public void saveUser(UserDto user) {

    }

    public void updateUser(Integer id, UserDto user) {

    }

    public void deleteUser(Integer id) {

    }
}
