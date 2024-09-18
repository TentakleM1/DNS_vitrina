package ru.dns.vitrina.server.controller.model.vitrina;

import lombok.Data;

@Data
public class VitrinaRequest {
    private int id;
    private String name;
    private String blockId;
}
