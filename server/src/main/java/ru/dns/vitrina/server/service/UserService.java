package ru.dns.vitrina.server.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.dns.vitrina.server.model.User;
import ru.dns.vitrina.server.storage.inheritance.UserStorage;

import java.util.List;

@Service
@Slf4j
@Validated
@RequiredArgsConstructor
public class UserService {
    private final UserStorage userStorage;

    public User create(User user) {
        return userStorage.createUser(user);
    }

    public User update(User user) {
        return userStorage.updateUser(user);
    }

    public void delete(long id) {
        userStorage.deleteUser(id);
    }

    public User findById(long id) {
        return userStorage.getUser(id);
    }

    public User getUser(User user) {
        String lastName = user.getLastName();
        String password = user.getPassword();
        return userStorage.getUserSign(lastName, password);
    }

    public List<User> getUsers() {
        return userStorage.getUsers();
    }

    public void addMessage(int messageId, long userId) {
        userStorage.addMessage(messageId, userId);
    }

    public void deleteMessage(int messageId, long userId) {
        userStorage.deleteMessage(messageId, userId);
    }

    public void addBlock(int blockId, long userId) {
        userStorage.addBlock(blockId, userId);
    }

    public void deleteBlock(int blockId, long userId) {
        userStorage.deleteBlock(blockId, userId);
    }
}
