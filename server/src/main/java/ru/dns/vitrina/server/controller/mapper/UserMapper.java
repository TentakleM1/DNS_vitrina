package ru.dns.vitrina.server.controller.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.dns.vitrina.server.controller.dto.animal.AnimalDto;
import ru.dns.vitrina.server.controller.dto.color.ColorDto;
import ru.dns.vitrina.server.controller.dto.user.UserDto;
import ru.dns.vitrina.server.controller.dto.user.UserRequest;
import ru.dns.vitrina.server.controller.dto.vitrina.VitrinaDto;
import ru.dns.vitrina.server.model.Animal;
import ru.dns.vitrina.server.model.Color;
import ru.dns.vitrina.server.model.User;
import ru.dns.vitrina.server.model.Vitrina;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserMapper {
    public static UserDto mapToUserDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setLastName(user.getLastName());
        dto.setPassword(user.getPassword());
        dto.setRoot(user.isRoot());
        List<AnimalDto> avatar = user.getAvatar().stream()
                .sorted(Animal::compareTo)
                .map(AnimalMapper::mapToAnimalDto)
                .toList();
        List<ColorDto> color = user.getColor().stream()
                .sorted(Color::compareTo)
                .map(ColorMapper::mapToColorDto)
                .toList();
        List<VitrinaDto> vitrina = user.getVitrina().stream()
                .sorted(Vitrina::compareTo)
                .map(VitrinaMapper::mapToVitrinaDto)
                .toList();
        dto.setAvatar(avatar);
        dto.setColor(color);
        dto.setVitrina(vitrina);
        return dto;
    }

    public static User mapToUser(UserRequest request) {
        User user = new User();
        user.setId(request.getId());
        user.setName(request.getName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        user.setRoot(request.isRoot());
        List<Animal> avatar = request.getAvatar().stream()
                .map(AnimalMapper::mapToAnimal)
                .toList();
        List<Color> color = request.getColor().stream()
                .map(ColorMapper::mapToColor)
                .toList();
        user.setAvatar(avatar);
        user.setColor(color);
        return user;
    }
}
