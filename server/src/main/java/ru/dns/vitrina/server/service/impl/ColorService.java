package ru.dns.vitrina.server.service.impl;


import ru.dns.vitrina.server.model.Color;

public interface ColorService {
    void update(long userId);

    Color searchNullableColorUser();
}
