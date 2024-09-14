package ru.dns.vitrina.server.controller.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.dns.vitrina.server.controller.model.user.UserDto;
import ru.dns.vitrina.server.controller.model.user.UserRequest;
import ru.dns.vitrina.server.model.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserMapper {
    public static UserDto mapToUserDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setLastName(user.getLastName());
        dto.setPassword(user.getPassword());
        dto.setRoot(user.isRoot());
        return dto;
    }

    public static User mapToUser(UserRequest request) {
        User user = new User();
        user.setId(request.getId());
        user.setName(request.getName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        user.setRoot(request.isRoot());
        return user;
    }
}
