package ru.dns.vitrina.server.service.impl;


import ru.dns.vitrina.server.model.Animal;

public interface AnimalService {
    void update(long userId);

    Animal searchNullableAnimalUser();

}
