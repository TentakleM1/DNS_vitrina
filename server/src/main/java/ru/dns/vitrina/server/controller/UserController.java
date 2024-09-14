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
    @PostMapping("/create-task/{userId}/{taskId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTask(@PathVariable Long userId, @PathVariable int taskId) {
        userService.saveTask(userId, taskId);
    }

    @CrossOrigin
    @DeleteMapping("/remove-task/{userId}/{taskId}")
    public void removeTask(@PathVariable Long userId, @PathVariable int taskId) {
        userService.deleteTask(userId, taskId);
    }

    @CrossOrigin
    @PostMapping("/create-block/{userId}/{blockId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBlock(@PathVariable Long userId, @PathVariable int blockId) {
        userService.saveBlock(userId, blockId);
    }

    @CrossOrigin
    @DeleteMapping("/remove-block/{userId}/{blockId}")
    public void removeBlock(@PathVariable Long userId, @PathVariable int blockId) {
        userService.deleteBlock(userId, blockId);
    }

    @CrossOrigin
    @DeleteMapping("/remove-all-blocks/{userId}")
    public void removeAllBlock(@PathVariable Long userId) {
        userService.deleteBlocks(userId);
    }

    @CrossOrigin
    @DeleteMapping("/remove-all-tasks/{userId}")
    public void removeAllTask(@PathVariable Long userId) {
        userService.deleteTasks(userId);
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
