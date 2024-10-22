package ru.dns.vitrina.server.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.dns.vitrina.server.user.dto.RegistrationUserDto;
import ru.dns.vitrina.server.user.dto.SignInUserDto;
import ru.dns.vitrina.server.user.dto.UserDto;
import ru.dns.vitrina.server.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService service;

    @CrossOrigin
    @PostMapping("/sign-in")
    public UserDto getUser(@RequestBody SignInUserDto dto) {
        log.info("sign-in user: {}", dto);
        UserDto signedInUser = service.signInUser(dto);
        log.info("sign-ined user: {}", signedInUser);
        return signedInUser;
    }

    @CrossOrigin
    @PostMapping("/create-user")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody RegistrationUserDto dto) {
        log.info("create user: {}", dto);
        service.save(dto);
    }

    @CrossOrigin
    @PostMapping("/logout")
    @ResponseStatus(HttpStatus.OK)
    public void logout() {
    }

    @CrossOrigin
    @GetMapping("/users")
    public List<UserDto> getUsers() {
        log.info("get users");
        List<UserDto> userDtos = service.findAll();
        log.info("get users: {}\n", userDtos);
        return userDtos;
    }
}
