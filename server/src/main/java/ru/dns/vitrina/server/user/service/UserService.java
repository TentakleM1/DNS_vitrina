package ru.dns.vitrina.server.user.service;

import ru.dns.vitrina.server.user.dto.RegistrationUserDto;
import ru.dns.vitrina.server.user.dto.SignInUserDto;
import ru.dns.vitrina.server.user.dto.UserDto;

import java.util.List;

public interface UserService {
    void save(RegistrationUserDto dto);

    UserDto signInUser(SignInUserDto dto);

    void delete(long userId);

    List<UserDto> findAll();
}
