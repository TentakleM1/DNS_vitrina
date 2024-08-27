package ru.dns.vitrina.server.storage.inheritance;

import ru.dns.vitrina.server.model.User;

import java.util.List;

public interface UserStorage {
    User createUser(User user);

    User updateUser(User user);

    void deleteUser(long userId);

    User getUser(long userId);

    User getUserSign(String lastName, String password);

    List<User> getUsers();
}
