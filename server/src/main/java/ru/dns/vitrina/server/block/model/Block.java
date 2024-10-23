package ru.dns.vitrina.server.block.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "blocks")
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Integer x;
    @Column(nullable = false)
    private Integer y;
    @Column(nullable = false)
    private Integer width;
    @Column(nullable = false)
    private Integer height;
}
