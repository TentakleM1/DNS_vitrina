package ru.dns.vitrina.server.controller.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.dns.vitrina.server.controller.model.color.ColorDto;
import ru.dns.vitrina.server.controller.model.color.ColorRequest;
import ru.dns.vitrina.server.model.Color;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ColorMapper {
    public static ColorDto mapToColorDto(Color color) {
        ColorDto dto = new ColorDto();
        dto.setId(color.getId());
        dto.setColor(color.getColor());
        return dto;
    }
    public static Color mapToColor(ColorRequest request) {
        Color color = new Color();
        color.setId(request.getId());
        color.setColor(request.getColor());
        return color;
    }
}
