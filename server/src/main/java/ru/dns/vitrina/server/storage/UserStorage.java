package ru.dns.vitrina.server.storage;

import ru.dns.vitrina.server.model.User;

import java.util.HashMap;

public class UserStorage {
    long counter = 0;
    HashMap<Long, User> users = new HashMap<>();

    public User createUser(User user) {
        user.setId(getNextId());
        users.put(user.getId(), user);
        return user;
    }

    public User getUser(User user) {
        for (User u : users.values()) {
            if(u.getLogin().equals(user.getLogin()) && u.getPassword().equals(user.getPassword())) {
                return u;
            }
        }
        return null;
    }

    private long getNextId() {
        return ++counter;
    }
}
