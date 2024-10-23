package ru.dns.vitrina.server.animal.mapper;

import ru.dns.vitrina.server.animal.dto.AnimalDto;
import ru.dns.vitrina.server.animal.model.Animal;

public final class AnimalMapper {
    public static AnimalDto mapToAnimalDto(Animal animal) {
        AnimalDto dto = new AnimalDto();
        dto.setId(animal.getId());
        dto.setName(animal.getName());
        return dto;
    }

    public static Animal mapToAnimal(AnimalDto dto) {
        Animal animal = new Animal();
        animal.setId(dto.getId());
        animal.setName(dto.getName());
        return animal;
    }
}
