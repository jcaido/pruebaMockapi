package com.jcaido.pruebaMockapi.service;

import com.jcaido.pruebaMockapi.dto.UserDto;
import com.jcaido.pruebaMockapi.exception.ResourceAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        List<UserDto> users = Arrays.asList(restTemplate.getForObject(basePath + "/users", UserDto[].class));

        boolean userNameAlreadyExist = users.stream().noneMatch(userMatch -> userMatch.getUsername().equals(user.getUsername()));
        if (!userNameAlreadyExist)
            throw new ResourceAlreadyExistException("user", "username", String.valueOf(user.getUsername()));

        boolean emailAlreadyExist = users.stream().noneMatch(userMatch -> userMatch.getEmail().equals(user.getEmail()));
        if (!emailAlreadyExist)
            throw new ResourceAlreadyExistException("user", "email", String.valueOf(user.getEmail()));

        restTemplate.postForObject(basePath + "/users", user, UserDto.class);
    }

    public void updateUser(Integer id, UserDto user) {
        restTemplate.put(basePath + "/users/" + id, user);
    }

    public void deleteUser(Integer id) {
        restTemplate.delete(basePath + "/users/" + id);
    }
}
