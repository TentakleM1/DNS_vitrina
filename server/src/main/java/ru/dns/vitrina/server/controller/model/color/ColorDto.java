package ru.dns.vitrina.server.controller.model.color;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ColorDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;
    private String color;
}
