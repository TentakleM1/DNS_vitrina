package ru.dns.vitrina.server.service.impl;

import ru.dns.vitrina.server.controller.dto.user.UserDto;

public interface UserService {
    void save(UserDto dto);

    void delete(long userId);
}
