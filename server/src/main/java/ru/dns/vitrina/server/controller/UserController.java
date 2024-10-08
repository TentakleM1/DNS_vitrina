package ru.dns.vitrina.server.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.dns.vitrina.server.model.User;
import ru.dns.vitrina.server.service.UserService;
import ru.dns.vitrina.server.storage.dao.UserDatabaseStorage;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping
public class UserController {
    private final UserService userService;


    @CrossOrigin
    @PostMapping("/sign-up")
    public User createUser(@RequestBody User user) {
        log.info("GET Запрос на создание пользователя {}", user);
        System.out.println(user.toString());
        return userService.create(user);
    }
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
        //log.info("GET Запрос на поиск пользователя по id {}", id);
        return userService.getUser(user);
    }
//
//    @GetMapping()
//    public List<User> getUsers() {
//        log.info("GET Запрос на список пользователей");
//        return userService.getUsers();
//    }
//
//    @GetMapping("/{id}/friends")
//    public List<User> getFriends(@PathVariable("id") @Positive int id) {
//        log.info("GET Запрос на список друзей пользователя id {}", id);
//        return userService.getAllFriends(id);
//    }
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
