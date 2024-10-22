package ru.dns.vitrina.server.controller.dto.vitrina;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VitrinaDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;
    private String name;
    private int blockId;
}
