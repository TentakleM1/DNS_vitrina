package ru.dns.vitrina.server.vitrina.mapper;

import ru.dns.vitrina.server.vitrina.dto.VitrinaDto;
import ru.dns.vitrina.server.vitrina.model.Vitrina;

public class VitrinaMapper {
    public static VitrinaDto mapToDto(Vitrina vitrina) {
        VitrinaDto dto = new VitrinaDto();
        dto.setId(vitrina.getId());
        dto.setName(vitrina.getName());
        dto.setBlock(vitrina.getBlock());
        return dto;
    }

    public static Vitrina mapToVitrina(VitrinaDto dto) {
        Vitrina vitrina = new Vitrina();
        vitrina.setId(dto.getId());
        vitrina.setName(dto.getName());
        vitrina.setBlock(dto.getBlock());
        return vitrina;
    }
}
