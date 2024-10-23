package ru.dns.vitrina.server.color.mapper;

import ru.dns.vitrina.server.color.dto.ColorDto;
import ru.dns.vitrina.server.color.model.Color;

public class ColorMapper {
    public static ColorDto mapToColorDto(Color color) {
        ColorDto dto = new ColorDto();
        dto.setId(color.getId());
        dto.setColor(color.getColor());
        return dto;
    }

    public static Color mapToColor(ColorDto dto) {
        Color color = new Color();
        color.setId(dto.getId());
        color.setColor(dto.getColor());
        return color;
    }
}
