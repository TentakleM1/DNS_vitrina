package ru.dns.vitrina.server.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Color implements Comparable<Color> {
    private Integer id;
    private String color;

    @Override
    public int compareTo(Color o) {
        return this.id.compareTo(o.getId());
    }
}
