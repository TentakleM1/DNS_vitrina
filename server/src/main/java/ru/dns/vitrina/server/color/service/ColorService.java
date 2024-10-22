package ru.dns.vitrina.server.color.service;


import ru.dns.vitrina.server.color.model.Color;

public interface ColorService {
    void update(long userId);

    Color searchNullableColorUser();
}
