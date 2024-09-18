package ru.dns.vitrina.server.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Animal implements Comparable<Animal> {
    private Integer id;
    private String name;

    @Override
    public int compareTo(Animal o) {
        return this.id.compareTo(o.getId());
    }
}
