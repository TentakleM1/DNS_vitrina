package ru.dns.vitrina.server.model;

import lombok.Data;

@Data
public class Block {
    private final int id;
    private final String name;
    private final int x;
    private final int y;
    private final int length;
    private final int height;
}
