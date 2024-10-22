package ru.dns.vitrina.server.animal.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.dns.vitrina.server.animal.dto.AnimalDto;
import ru.dns.vitrina.server.animal.model.Animal;
import ru.dns.vitrina.server.controller.dto.animal.AnimalRequest;

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
