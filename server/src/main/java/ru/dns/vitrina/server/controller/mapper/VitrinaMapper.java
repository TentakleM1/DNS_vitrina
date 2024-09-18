package ru.dns.vitrina.server.controller.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.dns.vitrina.server.controller.model.vitrina.VitrinaDto;
import ru.dns.vitrina.server.model.Vitrina;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class VitrinaMapper {
    public static VitrinaDto mapToVitrinaDto(Vitrina vitrina) {
        VitrinaDto dto = new VitrinaDto();
        dto.setId(vitrina.getId());
        dto.setName(vitrina.getName());
        dto.setBlockId(vitrina.getBlockId());
        return dto;
    }

    public static Vitrina mapToVitrina(VitrinaDto dto) {
        Vitrina vitrina = new Vitrina();
        vitrina.setId(dto.getId());
        vitrina.setName(dto.getName());
        vitrina.setBlockId(dto.getBlockId());
        return vitrina;
    }
}
