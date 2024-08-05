package ru.dns.vitrina.server.model;

import lombok.Data;

@Data
public class User {
    private long id;
    private String login;
    private String password;
}
