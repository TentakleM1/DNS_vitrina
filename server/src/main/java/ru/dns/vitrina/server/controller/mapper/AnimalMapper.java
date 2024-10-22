package ru.dns.vitrina.server.controller.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.dns.vitrina.server.controller.dto.animal.AnimalDto;
import ru.dns.vitrina.server.controller.dto.animal.AnimalRequest;
import ru.dns.vitrina.server.model.Animal;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AnimalMapper {
    public static AnimalDto mapToAnimalDto(Animal animal) {
        AnimalDto dto = new AnimalDto();
        dto.setId(animal.getId());
        dto.setName(animal.getName());
        return dto;
    }

    public static Animal mapToAnimal(AnimalRequest request) {
        Animal animal = new Animal();
        animal.setId(request.getId());
        animal.setName(request.getName());
        return animal;
    }
}
