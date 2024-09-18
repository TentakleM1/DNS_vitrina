package ru.dns.vitrina.server.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.dns.vitrina.server.controller.model.user.UserDto;
import ru.dns.vitrina.server.controller.model.user.UserRequest;
import ru.dns.vitrina.server.service.inheritance.UserService;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @CrossOrigin
    @PostMapping("/sign-in")
    public UserDto getUser(@RequestBody UserRequest request) {
        return userService.getUserSign(request);
    }

    @CrossOrigin
    @PostMapping("/create-user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@Valid @RequestBody UserRequest request) {
        return userService.save(request);
    }

    @CrossOrigin
    @PostMapping("/logout")
    @ResponseStatus(HttpStatus.OK)
    public void logout() {
    }

    @CrossOrigin
    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return userService.getAll();
    }
}
