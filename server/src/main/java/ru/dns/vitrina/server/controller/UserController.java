package ru.dns.vitrina.server.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.dns.vitrina.server.model.User;
import ru.dns.vitrina.server.service.UserService;
import ru.dns.vitrina.server.validator.group.Create;
import ru.dns.vitrina.server.validator.group.Default;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping
public class UserController {
    private final UserService userService;


//    @CrossOrigin
//    @PostMapping("/sign-up")
//    public User logUser(@RequestBody User user) {
//        log.info("GET Запрос на создание пользователя {}", user);
//        System.out.println(user.toString());
//        return userService.create(user);
//    }
//
//    @PutMapping
//    public User updateUser(@RequestBody @Validated({Update.class, Default.class}) User user) {
//        log.info("PUT Запрос на обновление данных пользователя {}", user);
//        return userService.updateUser(user);
//    }
//
    @CrossOrigin
    @PostMapping("/sign-in")
    public User getUser(@RequestBody User user) {
        log.info("POST Запрос на пользователя");
        return userService.getUser(user);
    }

    @CrossOrigin
    @PostMapping("/create-user")
    public User createUser(@RequestBody User user) {
        log.info("POST Запрос на создание пользователей");
        return userService.create(user);
    }
//
    @CrossOrigin
    @PostMapping("/logout")
    public void logout() {
        log.info("POST Запрос на выход пользователя");
        HttpStatus.OK.value();
    }

    @CrossOrigin
    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }
//
//    @GetMapping("/{id}/friends/common/{otherId}")
//    public List<User> getCommonFriends(@PathVariable("id") @Positive long id, @PathVariable("otherId") @Positive long otherId) {
//        log.info("GET Запрос на список общих друзей пользователя id {} и пользователя id {}", id, otherId);
//        return userService.getCommonFriends(id, otherId);
//    }
//
//
//    @PutMapping("/{id}/friends/{friendId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void addFriend(@PathVariable @Positive long id, @PathVariable @Positive long friendId) {
//        log.info("PUT Запрос на добавление пользователем id {} в друзья пользователя id {}", id, friendId);
//        userService.addFriend(id, friendId);
//    }
//
//    @DeleteMapping("/{id}/friends/{friendId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteFriend(@PathVariable("id") @Positive long id, @PathVariable("friendId") @Positive long friendId) {
//        log.info("DELETE Запрос на удаление пользователем id {} друга пользователя id {}", id, friendId);
//        userService.removeFriend(id, friendId);
//    }
}
