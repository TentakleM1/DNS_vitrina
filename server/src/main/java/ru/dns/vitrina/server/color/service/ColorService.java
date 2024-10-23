package ru.dns.vitrina.server.color.service;


import ru.dns.vitrina.server.color.dto.ColorDto;

import java.util.List;

public interface ColorService {
    List<ColorDto> findAll();

    ColorDto findById(int id);
}
