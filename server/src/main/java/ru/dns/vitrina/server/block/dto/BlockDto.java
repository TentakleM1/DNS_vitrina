package ru.dns.vitrina.server.block.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlockDto {
    private int id;
    private int x;
    private int y;
    private int width;
    private int height;
}
