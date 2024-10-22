package ru.dns.vitrina.server.animal.service;


import ru.dns.vitrina.server.animal.model.Animal;

public interface AnimalService {
    void update(long userId);

    Animal searchNullableAnimalUser();

}
