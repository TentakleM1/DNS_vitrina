package ru.dns.vitrina.server.controller.dto.block;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BlockDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;
    private int x;
    private int y;
    private int width;
    private int height;
}
