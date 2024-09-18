package ru.dns.vitrina.server.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Vitrina implements Comparable<Vitrina> {
    private Integer id;
    private String name;
    private int blockId;

    @Override
    public int compareTo(Vitrina o) {
        return this.id.compareTo(o.getId());
    }
}
