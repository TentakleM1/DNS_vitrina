package ru.dns.vitrina.server.controller.dto.block;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BlockRequest {
    private int id;
    @NotBlank(message = "пустой х")
    private int x;
    @NotBlank(message = "пустой у")
    private int y;
    @NotBlank(message = "пустая длина")
    private int width;
    @NotBlank(message = "пустая высота")
    private int height;
}
