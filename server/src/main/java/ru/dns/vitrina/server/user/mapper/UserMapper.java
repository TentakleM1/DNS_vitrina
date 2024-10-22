package ru.dns.vitrina.server.user.mapper;


import lombok.RequiredArgsConstructor;
import ru.dns.vitrina.server.user.dto.RegistrationUserDto;
import ru.dns.vitrina.server.user.dto.SignInUserDto;
import ru.dns.vitrina.server.user.dto.UserDto;
import ru.dns.vitrina.server.user.model.User;

@RequiredArgsConstructor
public class UserMapper {
    public static UserDto mapToDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setLastName(user.getLastName());
        dto.setRoot(user.isRoot());
        dto.setAvatar(user.getAnimal());
        dto.setColor(user.getColor());
        dto.setVitrina();
        );
    }

    public static User mapToUserRegistration(RegistrationUserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setLastName(dto.getLastName());
        user.setColor(dto.getColor());
        user.setAnimal(dto.getAnimal());
        user.setRoot(dto.isRoot());
        user.setPassword(dto.getPassword());
        return user;
    }

    public static User mapToSignInUser(SignInUserDto dto) {
        User user = new User();
        user.setLastName(dto.getLastName());
        user.setPassword(dto.getPassword());
        return user;
    }
}
